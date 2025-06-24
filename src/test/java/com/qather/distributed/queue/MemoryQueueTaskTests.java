package com.qather.distributed.queue;

import com.qather.distributed.event.task.dto.MemoryTaskParam;
import com.qather.distributed.event.task.model.QueueTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MemoryQueueTaskTests {


    @Autowired
    QueueTask<MemoryTaskParam> queueTask;


    @Test
    @DisplayName("메모리 큐에 순차적으로 적재 한다.")
    void test() {

    }
}
