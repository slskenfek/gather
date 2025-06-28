package com.qather.distributed.event.log.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 어떤 에러가 발생 하였는가? 클라이언트 - Exception 예외 발송
 */
@NoArgsConstructor
@Getter
@Setter
public class ErrorParam {
    private int id;
    private String code;
    private String stace;
    private String errorMsg;
    private LocalDateTime time;
}
