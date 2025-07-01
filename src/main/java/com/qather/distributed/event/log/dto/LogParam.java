package com.qather.distributed.event.log.dto;

import com.qather.distributed.event.log.out.entity.AccessLog;
import com.qather.distributed.event.users.out.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LogParam {

    private String userId;
    private String type;
    private String payload;
    private LocalDateTime time;

    /**
     * cascade 주의 : users
     */
    public AccessLog toAccessLogEntity() {
        AccessLog accessLog = new AccessLog();
        Users users = new Users();
        users.setUserId(userId);
        accessLog.setUsers(users);
        accessLog.setType(type);
        accessLog.setPayload(payload);
        accessLog.setTime(time);

        return accessLog;
    }
}
