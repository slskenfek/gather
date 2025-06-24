package com.qather.distributed.event.log.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class LogParam {

    private String userId;
    private String type;
    private String payload;
    private LocalDateTime time;
}
