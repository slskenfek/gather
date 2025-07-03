package com.qather.distributed.event.log.out.repository;

import com.qather.distributed.event.log.dto.LogResponse;
import com.qather.distributed.event.log.dto.QLogResponse_AccessLog;
import com.qather.distributed.event.log.dto.SearchLogRequest;
import com.qather.distributed.event.log.out.entity.QAccessLog;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.qather.distributed.event.log.out.entity.QAccessLog.accessLog;

@Repository
@RequiredArgsConstructor
public class AccessLogReadRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<LogResponse.AccessLog> searchAccessLog(SearchLogRequest.AccessParam accessParam, Pageable pageable) {
        return jpaQueryFactory.select(new QLogResponse_AccessLog(
                        accessLog.id,
                        accessLog.users.userId,
                        accessLog.payload,
                        accessLog.type,
                        accessLog.time
                )).from(accessLog).
                where(
                        eqUserId(accessParam.getUserId()),
                        eqPayload(accessParam.getPayload()),
                        eqType(accessParam.getType())

                ).offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }


    public Long countAccessLog(SearchLogRequest.AccessParam accessParam) {
        return null;
    }

    private BooleanExpression eqUserId(String userId) {
        if (!StringUtils.hasText(userId)) {
            return null;
        }

        return accessLog.users.userId.eq(userId);
    }

    private BooleanExpression eqType(String type) {
        if (!StringUtils.hasText(type)) {
            return null;
        }

        return accessLog.type.eq(type);

    }

    private BooleanExpression eqPayload(String payload) {
        if (!StringUtils.hasText(payload)) {
            return null;
        }

        return accessLog.payload.eq(payload);
    }


}
