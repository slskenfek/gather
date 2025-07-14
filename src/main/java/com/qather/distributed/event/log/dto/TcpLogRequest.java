package com.qather.distributed.event.log.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TcpLogRequest {

    private String type;
    private Map<String, Object> payload;
}
