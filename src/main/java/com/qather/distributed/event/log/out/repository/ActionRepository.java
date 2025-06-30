package com.qather.distributed.event.log.out.repository;

import com.qather.distributed.event.log.out.entity.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<ActionLog ,Long> {
}
