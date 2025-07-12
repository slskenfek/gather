package com.qather.distributed.event.consumer.worker;

import com.qather.distributed.event.log.service.ElasticsearchLogEventService;
import com.qather.distributed.event.log.service.DatabaseLogEventService;
import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.log.service.LogEventService;
import com.qather.distributed.event.producer.model.QueueFactory;
import com.qather.distributed.event.producer.model.QueueTask;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;


public class LogQueueWorker<T> implements Runnable {

    private final QueueTask<T> queueTask;
    private final List<Consumer<T>> consumers;
    private final static Logger LOGGER = LoggerFactory.getLogger(LogQueueWorker.class);

    public LogQueueWorker(QueueTask<T> queueTask, List<Consumer<T>> consumers) {
        this.queueTask = queueTask;
        this.consumers = consumers;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                T take = queueTask.take();
                consumers.forEach(consumers -> {
                    consumers.accept(take);
                });
            } catch (InterruptedException e) {
                LOGGER.error("인터럽트 에러 발생! {}", e.getMessage());
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                LOGGER.error("이벤트 루프 내부 에러 발생 : {}", e.getMessage());
            }

        }

    }

}
