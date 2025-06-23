package com.qather.distributed.event.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class TaskParam {

    private String code;
    private String type;
    private String payload;

}
