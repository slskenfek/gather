package com.qather.distributed.event.producer.config;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.MemoryLogQueueTask;
import com.qather.distributed.event.producer.model.QueueTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration
public class QueueConfig {

    @Bean("logQueue")
    public QueueTask<LogParam> logQueue() {
        return new MemoryLogQueueTask<LogParam>(50);
    }
    @Bean("actionQueue")
    public QueueTask<ActionParam> actionQueue() {
        return new MemoryLogQueueTask<ActionParam>(50);
    }
    @Bean("errorQueue")
    public QueueTask<ErrorParam> errorQueue() {
        return new MemoryLogQueueTask<ErrorParam>(10);
    }

}*/
