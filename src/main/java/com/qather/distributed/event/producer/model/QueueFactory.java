package com.qather.distributed.event.producer.model;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;

public class QueueFactory {

    private static final QueueTask<LogParam> logQueue = new MemoryLogQueueTask<>(50);
    private static final QueueTask<ActionParam> actionQueue = new MemoryLogQueueTask<>(50);
    private static final QueueTask<ErrorParam> errorQueue = new MemoryLogQueueTask<>(10);


    public static QueueTask<LogParam> getLogQueue() {
        return logQueue;
    }

    public static QueueTask<ActionParam> getActionQueue() {
        return actionQueue;
    }

    public static QueueTask<ErrorParam> getErrorQueue() {
        return errorQueue;
    }

}
