package com.qather.distributed.event.log.out.repository;

import com.qather.distributed.event.log.dto.LogResponse;
import com.qather.distributed.event.log.dto.SearchLogRequest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ActionLogReadRepository {
    private final JPAQueryFactory jpaQueryFactory;


    public List<LogResponse.ActionLog> searchActionLog(SearchLogRequest.ActionParam actionParam, Pageable pageable) {
        return List.of();
    }


    public Long countActionLog(SearchLogRequest.ActionParam actionParam) {
        return null;
    }
}
