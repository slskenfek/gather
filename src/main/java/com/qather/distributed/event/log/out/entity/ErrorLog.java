package com.qather.distributed.event.log.out.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "error_log")
@NoArgsConstructor
@Getter
@Setter
public class ErrorLog {
}
