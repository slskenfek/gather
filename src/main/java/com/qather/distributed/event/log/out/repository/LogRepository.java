package com.qather.distributed.event.log.out.repository;

import com.qather.distributed.event.log.out.entity.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<AccessLog, Long> {
}
