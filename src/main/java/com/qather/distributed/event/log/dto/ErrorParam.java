package com.qather.distributed.event.log.dto;

import com.qather.distributed.event.log.out.entity.ErrorLog;
import com.qather.distributed.event.users.out.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 어떤 에러가 발생 하였는가? 클라이언트 - Exception 예외 발송
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorParam {
    private String code;
    private String stace;
    private String errorMsg;
    private String userId;
    private LocalDateTime time;

    public ErrorLog toErrorLogEntity() {
        ErrorLog errorLog = new ErrorLog();
        Users users = new Users();
        users.setUserId(userId);
        users.setUsername("custom");
        errorLog.setErrorMsg(errorMsg);
        errorLog.setCode(code);
        errorLog.setUsers(users);
        errorLog.setTime(time);

        return errorLog;
    }

    @Override
    public String toString() {
        return "ErrorParam{" +
                "code='" + code + '\'' +
                ", stace='" + stace + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", userId='" + userId + '\'' +
                ", time=" + time +
                '}';
    }
}
