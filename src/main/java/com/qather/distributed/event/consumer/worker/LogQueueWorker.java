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

@Component
@RequiredArgsConstructor
public class LogQueueWorker {

    private final QueueTask<LogParam> logQueue = QueueFactory.getLogQueue();
    private final QueueTask<ActionParam> actionQueue = QueueFactory.getActionQueue();
    private final QueueTask<ErrorParam> errorQueue = QueueFactory.getErrorQueue();

    private final List<LogEventService> logEventService;


    private final static Logger log = LoggerFactory.getLogger(LogQueueWorker.class);


    public void workerStart() {
        logEventService.forEach(service -> {
            startWorkerThread(logQueue, List.of(service::createLog), "log-worker");
            startWorkerThread(actionQueue, List.of(service::createActionLog), "action-worker");
            startWorkerThread(errorQueue, List.of(service::errorLog), "error-worker");
        });

    }

    private <T> void startWorkerThread(QueueTask<T> queueTask, List<Consumer<T>> handler, String threadName) {

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    T task = queueTask.take();

                    if (task != null) {
                        handler.forEach(consumer -> consumer.accept(task));
                    }

                } catch (InterruptedException e) {
                    log.error("인터럽트 에러 발생! {}", e.getMessage());
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                    log.error("이벤트 루프 내부 에러 발생 : {}", e.getMessage());
                }
            }
        }, threadName).start();
    }

}
