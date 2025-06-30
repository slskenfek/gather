package com.qather.distributed.event.log.out.entity;

import com.qather.distributed.event.users.out.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 사용자 액션 데이터
 */
@Entity
@Table(name = "action_log")
@NoArgsConstructor
@Getter
@Setter
public class ActionLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 요청 URL
     */
    @Column(name = "url", length = 200, nullable = false)
    private String url;
    /**
     * 요청 데이터
     */
    @Column(name = "content", length = 100)
    private String content;

    @JoinColumn(name = "id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    private LocalDateTime time;

}
