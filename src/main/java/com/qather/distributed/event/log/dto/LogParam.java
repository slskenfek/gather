package com.qather.distributed.event.log.dto;

import com.qather.distributed.event.log.out.entity.AccessLog;
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

    public AccessLog toAccessLogEntity() {
        AccessLog accessLog = new AccessLog();
        accessLog.setUserId(userId);
        accessLog.setType(type);
        accessLog.setPayload(payload);
        accessLog.setTime(time);

        return accessLog;
    }
}
