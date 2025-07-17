package com.qather.distributed.socket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@RequiredArgsConstructor
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final LogSocketHandler logSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(logSocketHandler, "/ws/log/access").setAllowedOrigins("*");
        registry.addHandler(logSocketHandler, "/ws/log/error").setAllowedOrigins("*");
        registry.addHandler(logSocketHandler, "/ws/log/action").setAllowedOrigins("*");
    }
}
