package com.qather.distributed.event.log;


import com.qather.distributed.event.task.dto.MemoryTaskParam;
import com.qather.distributed.event.task.model.QueueTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogEventService {
    private final QueueTask<MemoryTaskParam> memoryTaskParamQueueTask;

}
