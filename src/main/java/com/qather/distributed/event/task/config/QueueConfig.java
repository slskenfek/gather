package com.qather.distributed.event.task.config;

import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.task.model.MemoryLogQueueTask;
import com.qather.distributed.event.task.model.QueueTask;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean("logQueue")
    public QueueTask<LogParam> logQueue() {
        return new MemoryLogQueueTask<LogParam>(50);
    }

}
