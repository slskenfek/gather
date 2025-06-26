package com.qather.distributed.event.consumer.worker;


import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.QueueTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogWorkerService {

    private final QueueTask<LogParam> queueTask;



    public void init() {
        queueTask.enqueueTask();

    }

}
