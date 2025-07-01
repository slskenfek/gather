package com.qather.distributed.event.log.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LogRequest {

    private LogParam logParam;

    private ActionParam actionParam;

    private ErrorParam errorParam;

}
