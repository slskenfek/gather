package com.qather.distributed.event.producer.model;

public interface QueueTask<T> {
    void createTask(T param);
    T poll();
    int size();

    T take() throws InterruptedException;
}
