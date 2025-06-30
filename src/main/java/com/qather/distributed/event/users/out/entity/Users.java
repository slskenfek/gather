package com.qather.distributed.event.users.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 요청 들어오는 클라이언트 정보 (회원가입, 로그인시 요청 받아야함)
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 사용자 아아디
     */
    @Column(name = "user_id", length = 50, nullable = false)
    private String userId;
    /**
     * 사용자 이름
     */
    @Column(name = "user_name", length = 10, nullable = false)
    private String username;

    /**
     * 이메일
     */
    @Column(name = "email", length = 100)
    private String email;

    /**
     * 접속 기기 확인
     */
    @Column(name = "user_agent", length = 10)
    private String userAgent;
}
