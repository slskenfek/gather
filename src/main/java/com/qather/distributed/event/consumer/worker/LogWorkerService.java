package com.qather.distributed.event.consumer.worker;


import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.QueueTask;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogWorkerService {

    private final QueueTask<LogParam> logQueue;

    private final QueueTask<ActionParam> actionQueue;

    private final QueueTask<ErrorParam> errorQueue;


    @Async("logExecutor")
    public void createLogQueue(LogParam logParam, ActionParam actionParam, ErrorParam errorParam) {
        logQueue.enqueueTask(logParam);
        actionQueue.enqueueTask(actionParam);
        errorQueue.enqueueTask(errorParam);

    }

}
