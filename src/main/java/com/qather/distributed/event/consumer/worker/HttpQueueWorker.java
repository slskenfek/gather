package com.qather.distributed.event.consumer.worker;

import com.qather.distributed.event.producer.model.QueueTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class HttpQueueWorker<T> implements Runnable {

    private final QueueTask<T> queueTask;
    private final List<Consumer<List<T>>> consumers;
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpQueueWorker.class);

    public HttpQueueWorker(QueueTask<T> queueTask, List<Consumer<List<T>>> consumers) {
        this.queueTask = queueTask;
        this.consumers = consumers;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                List<T> consumerList = new ArrayList<>();
                queueTask.drainTo(consumerList, 300);

                //T take = queueTask.take();
                consumers.forEach(consumers -> {
                    consumers.accept(consumerList);
                });
            } catch (InterruptedException e) {
                LOGGER.error("인터럽트 에러 발생! {}", e.getMessage());
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                LOGGER.error("이벤트 루프 내부 에러 발생 : {}", e.getMessage());
            }

        }

    }

}
