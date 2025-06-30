package com.qather.distributed.event.log.out.repository;

import com.qather.distributed.event.log.out.entity.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<ErrorLog, Long> {
}
