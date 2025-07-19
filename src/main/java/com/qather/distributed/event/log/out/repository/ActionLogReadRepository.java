package com.qather.distributed.event.log.out.repository;

import com.qather.distributed.event.log.dto.LogResponse;
import com.qather.distributed.event.log.dto.QLogResponse_ActionLog;
import com.qather.distributed.event.log.dto.SearchLogRequest;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.qather.distributed.event.log.out.entity.QActionLog.actionLog;

@Repository
@RequiredArgsConstructor
public class ActionLogReadRepository {
    private final JPAQueryFactory jpaQueryFactory;


    public List<LogResponse.ActionLog> searchActionLog(SearchLogRequest.ActionParam actionParam, Pageable pageable) {
        return jpaQueryFactory.select(new QLogResponse_ActionLog(
                        actionLog.id,
                        actionLog.url,
                        actionLog.content,
                        actionLog.users.userId,
                        actionLog.time
                ))
                .from(actionLog)
                .where(
                        likeUrl(actionParam.getUrl()),
                        likeContent(actionParam.getContent()),
                        eqUserId(actionParam.getUserId())
                ).limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

    }


    public Long countActionLog(SearchLogRequest.ActionParam actionParam) {
        return jpaQueryFactory.select(actionLog.count())
                .from(actionLog)
                .where(
                        likeUrl(actionParam.getUrl()),
                        likeContent(actionParam.getContent()),
                        eqUserId(actionParam.getUserId())
                ).fetchOne();

    }

    public List<LogResponse.ActionLog> selectAll() {
        return jpaQueryFactory.select(new QLogResponse_ActionLog(
                        actionLog.id,
                        actionLog.url,
                        actionLog.content,
                        actionLog.users.userId,
                        actionLog.time
                ))
                .from(actionLog)
                .fetch();
    }

    private BooleanExpression likeUrl(String url) {
        if (!StringUtils.hasText(url)) {
            return null;
        }
        return actionLog.url.contains(url);
    }

    private BooleanExpression likeContent(String content) {
        if (!StringUtils.hasText(content)) {
            return null;
        }
        return actionLog.content.contains(content);
    }

    private BooleanExpression eqUserId(String userId) {
        if (!StringUtils.hasText(userId)) {
            System.out.println("이거 왜 안탐?");
            return null;
        }
        return actionLog.users.userId.eq(userId);
    }

}
