package com.qather.distributed.event.producer.model;

import java.util.List;

public interface QueueTask<T> {
    void createTask(T param);

    T poll();

    int size();

    T take() throws InterruptedException;

    void drainTo(List<T> paramList, int size);
}
