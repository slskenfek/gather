package com.qather.distributed.event.log.dto;


import com.qather.distributed.event.log.out.entity.ActionLog;
import com.qather.distributed.event.users.out.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 액터가 어떤 API를 호출 하였는가? 체크
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ActionParam {

    private String url;
    private String content;
    private String userId;
    private LocalDateTime time;

    public ActionLog toActionLogEntity() {
        ActionLog actionLog = new ActionLog();
        Users users = new Users();
        users.setUserId(userId);
        users.setUsername("custom");
        actionLog.setContent(content);
        actionLog.setTime(time);
        actionLog.setUrl(url);
        actionLog.setUsers(users);

        return actionLog;
    }

}
