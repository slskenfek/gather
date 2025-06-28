package com.qather.distributed.event.consumer.worker;

import com.qather.distributed.event.log.LogEventService;
import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
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

    private final QueueTask<ActionParam> actionQueue;

    private final QueueTask<ErrorParam> errorQueue;

    private final LogEventService logEventService;


    //TODO 과연 이렇게 처리 하면 좋은가 ? ? ? 로직은 제네릭으로 통일 시키고 각자 나누는걸 고려해보자
    @PostConstruct
    public void init() {

        new Thread(() -> {
            while (true) {
                try {

                    LogParam logPoll = logQueue.take();

                    if (logPoll != null) {
                        logEventService.createLog(logPoll);
                    }

                    ActionParam actionPoll = actionQueue.take();

                    if (actionPoll != null) {

                    }

                    ErrorParam errorPoll = errorQueue.take();

                    if (errorPoll != null) {

                    }

                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

        }, "log-queue-thread").start();


    }

}
