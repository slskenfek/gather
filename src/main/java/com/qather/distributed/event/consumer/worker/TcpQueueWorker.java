package com.qather.distributed.event.consumer.worker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.QueueFactory;
import com.qather.distributed.event.producer.model.QueueTask;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@Component
@RequiredArgsConstructor
public class TcpQueueWorker {


    private static final int PORT = 9999;
    private static final Logger LOGGER = LoggerFactory.getLogger(TcpQueueWorker.class);
    private final ObjectMapper objectMapper;

    private final QueueTask<LogParam> queueTask = QueueFactory.getLogQueue();

    public void start() {
        new Thread(() -> {
            try (ServerSocket socket = new ServerSocket(PORT)) {

                while (!Thread.currentThread().isInterrupted()) {
                    Socket accept = socket.accept();
                    handleClient(accept);

                }

            } catch (IOException e) {
                LOGGER.error("IOException : {}", e.getMessage());
                Thread.currentThread().interrupt();
            }


        }, "tcp-log-worker").start();
    }

    private void handleClient(Socket socket) {
        new Thread(() -> {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    LogParam param = objectMapper.readValue(line, LogParam.class);
                    queueTask.createTask(param);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "tcp-client-handler").start();
    }
}
