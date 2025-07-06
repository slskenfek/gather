package com.qather.distributed.event.log.out.entity;

import com.qather.distributed.event.users.out.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 로그 데이터
 */
@Entity
@Table(name = "access_log")
@NoArgsConstructor
@Getter
@Setter
public class AccessLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;
    /**
     * 요청값
     */
    private String payload;
    /**
     * 형태
     */
    private String type;

    private LocalDateTime time;


}
