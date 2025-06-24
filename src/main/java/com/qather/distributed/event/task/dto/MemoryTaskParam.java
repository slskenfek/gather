package com.qather.distributed.event.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class MemoryTaskParam {

    private String code;
    private String type;
    private String payload;
    private LocalDateTime time;

}
