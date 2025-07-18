package com.qather.distributed.tcp.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qather.distributed.tcp.dispatcher.TcpMessageDispatcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TcpQueueHandler {

    private final TcpMessageDispatcher tcpMessageDispatcher;
    private final ObjectMapper objectMapper;


    public void handleClient(Socket socket) {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                Map<String, Object> param = objectMapper.readValue(line, new TypeReference<Map<String, Object>>() {
                });
                tcpMessageDispatcher.dispatch(param);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

