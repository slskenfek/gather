package com.qather.distributed.event.consumer.worker;

import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.QueueTask;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LogQueueWorker {

    @Qualifier("logQueue")
    private final QueueTask<LogParam> logQueue;

    public LogQueueWorker(QueueTask<LogParam> logQueue) {
        this.logQueue = logQueue;
    }

    @PostConstruct
    public void init() {

    }

}
