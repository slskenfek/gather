package com.qather.distributed.event.task.model;

public interface QueueTask<T> {
    void enqueueTask(T param);
    T dequeue();
    int size();

}
