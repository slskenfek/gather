package com.qather.distributed.tcp;

import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TcpQueueWorker {


    private final TcpBrokerProperty tcpBrokerProperty;
    private static final Logger LOGGER = LoggerFactory.getLogger(TcpQueueWorker.class);
    private final ObjectMapper objectMapper;
    private final QueueTask<LogParam> queueTask = QueueFactory.getLogQueue();

    public void start() {
        new Thread(() -> {
            try (ServerSocket socket = new ServerSocket(tcpBrokerProperty.getPort())) {

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
                    Map<String, Object> param = objectMapper.readValue(line, new TypeReference<Map<String, Object>>() {
                    });


                    queueTask.createTask(param);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "tcp-client-handler").start();
    }
}
