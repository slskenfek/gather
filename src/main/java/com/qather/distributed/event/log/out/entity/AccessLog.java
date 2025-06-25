package com.qather.distributed.event.log.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "access_log")
@NoArgsConstructor
@Getter
@Setter
public class AccessLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String payload;

    private String type;

    private LocalDateTime time;


}
