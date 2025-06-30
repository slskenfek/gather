package com.qather.distributed.event.log.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 액터가 어떤 API를 호출 하였는가? 체크
 */
@NoArgsConstructor
@Setter
@Getter
public class ActionParam {

    private String url;
    private String content;
    private String userId;
    private LocalDateTime time;

}
