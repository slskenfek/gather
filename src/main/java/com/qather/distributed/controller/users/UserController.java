package com.qather.distributed.controller.users;

import com.qather.distributed.event.users.dto.UserRequest;
import com.qather.distributed.event.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 클라이언트에서 로그인 하였을때 유저 정보를 기억 하기 위한 용도
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private final UserService userService;


    @PostMapping("")
    public ResponseEntity<Boolean> createUsers(@RequestBody UserRequest request) {
        userService.createUsers(request);
        return ResponseEntity.ok(true);
    }

}
