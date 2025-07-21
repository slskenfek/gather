package com.qather.distributed.event.tcp.server;

import com.qather.distributed.event.tcp.model.TcpBrokerProperty;
import com.qather.distributed.event.tcp.handler.TcpQueueHandler;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
@RequiredArgsConstructor
public class TcpQueueWorker {


    private final TcpBrokerProperty tcpBrokerProperty;
    private final TcpQueueHandler tcpQueueHandler;
    private static final Logger LOGGER = LoggerFactory.getLogger(TcpQueueWorker.class);
    private static Long NUMBER = 0L;


    @PostConstruct
    public void start() {
        new Thread(() -> {
            NUMBER++;
            try (ServerSocket socket = new ServerSocket(tcpBrokerProperty.getPort())) {

                while (!Thread.currentThread().isInterrupted()) {
                    Socket accept = socket.accept();
                    tcpQueueHandler.handleClient(accept);
                }

            } catch (IOException e) {
                LOGGER.error("TCP 수신 실패 : {}", e.getMessage());
                Thread.currentThread().interrupt();
            }


        }, "tcp-log-worker" + NUMBER).start();
    }


}
