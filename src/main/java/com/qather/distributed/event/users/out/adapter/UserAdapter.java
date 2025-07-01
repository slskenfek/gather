package com.qather.distributed.event.users.out.adapter;

import com.qather.distributed.event.users.dto.UserRequest;
import com.qather.distributed.event.users.out.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdapter {

    private final UserRepository repository;

    public void createUsers(UserRequest request) {
        repository.save(request.toUsersEntity());
    }

}
