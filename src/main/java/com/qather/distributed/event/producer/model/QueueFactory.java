package com.qather.distributed.event.producer.model;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import lombok.Getter;

public class QueueFactory {

    @Getter
    private static final QueueTask<LogParam> logQueue = new MemoryLogQueueTask<>(50);
    @Getter
    private static final QueueTask<ActionParam> actionQueue = new MemoryLogQueueTask<>(50);
    @Getter
    private static final QueueTask<ErrorParam> errorQueue = new MemoryLogQueueTask<>(10);


}
