package com.qather.distributed.event.producer.model;

public interface QueueTask<T> {
    void enqueueTask(T param);
    T dequeue();
    int size();

}
