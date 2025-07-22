package com.qather.distributed.event.producer.handler;


import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.QueueFactory;
import com.qather.distributed.event.producer.model.QueueTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogQueueDaemon {


    private final QueueTask<LogParam> logQueue = QueueFactory.getLogQueue();
    private final QueueTask<ActionParam> actionQueue = QueueFactory.getActionQueue();
    private final QueueTask<ErrorParam> errorQueue = QueueFactory.getErrorQueue();

    private static final Logger LOGGER = LoggerFactory.getLogger(LogQueueDaemon.class);

    @Async("logExecutor")
    public void createLogQueue(LogParam logParam, ActionParam actionParam, ErrorParam errorParam) {
        logQueue.createTask(logParam);
        actionQueue.createTask(actionParam);
        errorQueue.createTask(errorParam);

    }

}
