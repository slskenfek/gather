package com.qather.distributed.event.log.out.adapter;

import com.qather.distributed.event.log.dto.LogResponse;
import com.qather.distributed.event.log.dto.SearchLogRequest;
import com.qather.distributed.event.log.out.repository.AccessLogReadRepository;
import com.qather.distributed.event.log.out.repository.ActionLogReadRepository;
import com.qather.distributed.event.log.out.repository.ErrorLogReadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LogReadAdapter {

    private final AccessLogReadRepository accessLogReadRepository;
    private final ActionLogReadRepository actionLogReadRepository;
    private final ErrorLogReadRepository errorLogReadRepository;


    public PageImpl<LogResponse.AccessLog> searchAccessLog(SearchLogRequest.AccessParam accessParam, Pageable pageable) {
        Long total = accessLogReadRepository.countAccessLog(accessParam);
        List<LogResponse.AccessLog> resultList = accessLogReadRepository.searchAccessLog(accessParam, pageable);
        return new PageImpl<LogResponse.AccessLog>(resultList, pageable, total);
    }

    public PageImpl<LogResponse.ActionLog> searchActionLog(SearchLogRequest.ActionParam actionParam, Pageable pageable) {
        Long total = actionLogReadRepository.countActionLog(actionParam);
        List<LogResponse.ActionLog> resultList = actionLogReadRepository.searchActionLog(actionParam, pageable);
        return new PageImpl<LogResponse.ActionLog>(resultList, pageable, total);

    }

    public PageImpl<LogResponse.ErrorLog> searchErrorLog(SearchLogRequest.ErrorParam errorParam, Pageable pageable) {
        Long total = errorLogReadRepository.countErrorLog(errorParam);
        List<LogResponse.ErrorLog> resultList = errorLogReadRepository.searchErrorLog(errorParam, pageable);
        return new PageImpl<LogResponse.ErrorLog>(resultList, pageable, total);

    }

}
