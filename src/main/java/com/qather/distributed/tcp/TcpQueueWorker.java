package com.qather.distributed.tcp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.QueueFactory;
import com.qather.distributed.event.producer.model.QueueTask;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TcpQueueWorker {


    private final TcpBrokerProperty tcpBrokerProperty;
    private static final Logger LOGGER = LoggerFactory.getLogger(TcpQueueWorker.class);
    private final ObjectMapper objectMapper;
    private final QueueTask<LogParam> logQueue = QueueFactory.getLogQueue();
    private final QueueTask<ErrorParam> errorQueue = QueueFactory.getErrorQueue();
    private final QueueTask<ActionParam> actionQueue = QueueFactory.getActionQueue();


    @PostConstruct
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
                    if (param != null) {
                        String type = (String) param.get("type");
                        switch (type) {
                            case "error" -> {
                                ErrorParam errorParam = new ErrorParam(
                                        param.get("code").toString(),
                                        param.get("stace").toString(),
                                        param.get("errorMsg").toString(),
                                        param.get("userId").toString(),
                                        (LocalDateTime) param.get("time")
                                );
                                errorQueue.createTask(errorParam);
                            }
                            case "access" -> {
                                logQueue.createTask(param);
                            }
                            case "action" -> {
                                actionQueue.createTask(param);
                            }
                            default -> LOGGER.warn("알 수 없는 타입: {}", type);
                        }
                    }


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "tcp-client-handler").start();
    }
}
