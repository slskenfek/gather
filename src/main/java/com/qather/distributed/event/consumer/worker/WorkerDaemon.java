package com.qather.distributed.event.consumer.worker;


import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.log.service.LogEventService;
import com.qather.distributed.event.producer.model.QueueFactory;
import com.qather.distributed.event.producer.model.QueueTask;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class WorkerDaemon {


    private final QueueTask<LogParam> logQueueTask = QueueFactory.getLogQueue();
    private final QueueTask<ActionParam> actionQueueTask = QueueFactory.getActionQueue();
    private final QueueTask<ErrorParam> errorQueueTask = QueueFactory.getErrorQueue();
    private final List<LogEventService> logEventService;
    private final ThreadPoolTaskExecutor logExecutor;
    private final ThreadPoolTaskExecutor actionExecutor;
    private final ThreadPoolTaskExecutor errorExecutor;


    @PostConstruct
    public void startWorker() {

        logExecutor.execute(new HttpQueueWorker<>(
                logQueueTask, logEventService.stream().map(
                        service -> (Consumer<LogParam>) service::createLog)
                .toList()));

        actionExecutor.execute(new HttpQueueWorker<>(
                actionQueueTask, logEventService.stream().map(
                        service -> (Consumer<ActionParam>) service::createActionLog)
                .toList()));

        errorExecutor.execute(new HttpQueueWorker<>(
                errorQueueTask, logEventService.stream().map(
                service -> (Consumer<ErrorParam>) service::errorLog
        ).toList()));

    }


}
