package com.qather.distributed.event.log.out.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LogReadRepository {

    private final JPAQueryFactory jpaQueryFactory;

}
