package com.qather.distributed.event.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ConsumerPoolConfig {

    @Bean("logExecutor")
    public ThreadPoolTaskExecutor executorLog() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setThreadNamePrefix("access-worker-log");
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;

    }

    @Bean("actionExecutor")
    public ThreadPoolTaskExecutor executorAction() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setThreadNamePrefix("action-worker-log");
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;

    }

    @Bean("errorExecutor")
    public ThreadPoolTaskExecutor executorError() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setThreadNamePrefix("error-worker-log");
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;

    }
}
