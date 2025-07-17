package com.qather.distributed.socket.config;

import com.qather.distributed.tcp.TcpBrokerProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

@Component
@RequiredArgsConstructor
public class LogSocketHandler extends TextWebSocketHandler {

    private final TcpBrokerProperty tcpBrokerProperty;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        try (Socket socket = new Socket(tcpBrokerProperty.getHost(), tcpBrokerProperty.getPort())) {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
