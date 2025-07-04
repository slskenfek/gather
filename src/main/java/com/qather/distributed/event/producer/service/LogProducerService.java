package com.qather.distributed.event.producer.service;


import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.QueueFactory;
import com.qather.distributed.event.producer.model.QueueTask;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogProducerService {


    private final QueueTask<LogParam> logQueue = QueueFactory.getLogQueue();
    private final QueueTask<ActionParam> actionQueue = QueueFactory.getActionQueue();
    private final QueueTask<ErrorParam> errorQueue = QueueFactory.getErrorQueue();



    @Async("logExecutor")
    public void createLogQueue(LogParam logParam, ActionParam actionParam, ErrorParam errorParam) {
        logQueue.createTask(logParam);
        actionQueue.createTask(actionParam);
        errorQueue.createTask(errorParam);

    }

}
