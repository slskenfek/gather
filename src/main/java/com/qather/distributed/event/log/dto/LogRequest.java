package com.qather.distributed.event.log.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LogRequest {

    private LogParam logParam;

    private ActionParam actionParam;

    private ErrorParam errorParam;

}
