package com.qather.distributed.event.users.service;


import com.qather.distributed.event.users.dto.UserRequest;
import com.qather.distributed.event.users.out.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserAdapter userAdapter;


    public void createUsers(UserRequest request) {
        userAdapter.createUsers(request);
    }

}
