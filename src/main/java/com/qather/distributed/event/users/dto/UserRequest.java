package com.qather.distributed.event.users.dto;


import com.qather.distributed.event.users.out.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

    private String userId;

    private String username;

    private String email;

    private String userAgent;

    public Users toUsersEntity() {
        Users users = new Users();
        users.setUserId(userId);
        users.setUserAgent(userAgent);
        users.setUsername(username);
        users.setEmail(email);
        return users;
    }
}
