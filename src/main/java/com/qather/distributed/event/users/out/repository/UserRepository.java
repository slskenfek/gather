package com.qather.distributed.event.users.out.repository;

import com.qather.distributed.event.users.out.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
