package com.qather.distributed.event.consumer.worker;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkerDaemon {

    private final LogQueueWorker logQueueWorker;


    @PostConstruct
    public void startEventThread() {
        logQueueWorker.workerStart();
    }
}
