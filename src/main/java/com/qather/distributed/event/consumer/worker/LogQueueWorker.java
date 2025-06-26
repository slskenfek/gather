package com.qather.distributed.event.consumer.worker;

import com.qather.distributed.event.log.LogEventService;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.MemoryLogQueueTask;
import com.qather.distributed.event.producer.model.QueueTask;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogQueueWorker {


    private final QueueTask<LogParam> logQueue;
    private final LogEventService logEventService;



    @PostConstruct
    public void init() {

        new Thread(() -> {
            while (true) {
                try {

                    LogParam poll = logQueue.take();
                    if (poll != null) {
                        logEventService.createLog(poll);
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    break;
                }

            }


        }, "log-queue-thread").start();


    }

}
