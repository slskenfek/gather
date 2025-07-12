package com.qather.distributed.event.log.out.repository;

import com.qather.distributed.event.log.dto.LogResponse;
import com.qather.distributed.event.log.dto.QLogResponse_ErrorLog;
import com.qather.distributed.event.log.dto.SearchLogRequest;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.qather.distributed.event.log.out.entity.QErrorLog.errorLog;

@Repository
@RequiredArgsConstructor
public class ErrorLogReadRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<LogResponse.ErrorLog> searchErrorLog(SearchLogRequest.ErrorParam errorParam, Pageable pageable) {
        return jpaQueryFactory.select(new QLogResponse_ErrorLog(
                        errorLog.id,
                        errorLog.code,
                        errorLog.stace,
                        errorLog.errorMsg,
                        errorLog.users.userId,
                        errorLog.time
                )).from(errorLog)
                .where(
                        eqCode(errorParam.getCode()),
                        eqUserId(errorParam.getUserId()),
                        likeStace(errorParam.getStace()),
                        likeErrorMsg(errorParam.getErrorMsg())
                ).limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();
    }


    public Long countErrorLog(SearchLogRequest.ErrorParam errorParam) {
        return jpaQueryFactory.select(errorLog.count())
                .from(errorLog)
                .where(
                        eqCode(errorParam.getCode()),
                        eqUserId(errorParam.getUserId()),
                        likeStace(errorParam.getStace()),
                        likeErrorMsg(errorParam.getErrorMsg())
                ).fetchOne();
    }


    private BooleanExpression eqCode(String code) {
        if (!StringUtils.hasText(code)) {
            return null;
        }
        return errorLog.code.eq(code);

    }

    private BooleanExpression likeStace(String stace) {
        if (!StringUtils.hasText(stace)) {
            return null;
        }
        return errorLog.stace.contains(stace);
    }

    private BooleanExpression likeErrorMsg(String errorMsg) {
        if (!StringUtils.hasText(errorMsg)) {
            return null;
        }
        return errorLog.errorMsg.contains(errorMsg);
    }

    private BooleanExpression eqUserId(String userId) {
        if (!StringUtils.hasText(userId)) {
            return null;
        }
        return errorLog.users.userId.eq(userId);
    }

}
