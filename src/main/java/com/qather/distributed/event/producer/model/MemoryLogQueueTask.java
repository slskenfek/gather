package com.qather.distributed.event.producer.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class MemoryLogQueueTask<T> implements QueueTask<T> {

    private final BlockingQueue<T> queue;
    private static final Logger log = LoggerFactory.getLogger(MemoryLogQueueTask.class);

    public MemoryLogQueueTask(int capacity) {
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    @Override
    public void createTask(T param) {
        boolean check = queue.offer(param);
        if (!check) {
            log.warn("큐가 가득 찼습니다 {}", param);
            log.error("fail task push {}", size());
        }
    }

    @Override
    public T take() throws InterruptedException {
        return queue.take();
    }

    @Override
    public T poll() {
        return queue.poll();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void drainTo(List<T> paramList, int size) {
        queue.drainTo(paramList, size);
    }
}
