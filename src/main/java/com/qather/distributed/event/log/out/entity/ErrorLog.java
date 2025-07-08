package com.qather.distributed.event.log.out.entity;

import com.qather.distributed.event.users.out.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 에러 데이터
 */
@Entity
@Table(name = "error_log")
@NoArgsConstructor
@Getter
@Setter
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 에러 코드
     */
    @Column(name = "code", length = 30, nullable = false)
    private String code;
    /**
     * 에러 상세 내용
     */
    @Column(name = "stace", length = 200)
    private String stace;
    /**
     * 에러 메시지
     */
    @Column(name = "errorMsg", length = 100, nullable = false)
    private String errorMsg;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Users users;

    /**
     * 발생일
     */
    private LocalDateTime time;
}
