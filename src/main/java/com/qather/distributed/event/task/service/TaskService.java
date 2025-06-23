package com.qather.distributed.event.task.service;

import com.qather.distributed.event.task.dto.TaskParam;

public interface TaskService {
    void enqueueTask(TaskParam param);

}
