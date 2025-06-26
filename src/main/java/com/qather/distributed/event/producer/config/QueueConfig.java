package com.qather.distributed.event.producer.config;

import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.MemoryLogQueueTask;
import com.qather.distributed.event.producer.model.QueueTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public QueueTask<LogParam> logQueue() {
        return new MemoryLogQueueTask<LogParam>(50);
    }

}
