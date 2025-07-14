package com.qather.distributed.tcp;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("tcp.broker")
@Component
@Getter
@Setter
public class TcpBrokerProperty {

    private int port;
    private String host;

}
