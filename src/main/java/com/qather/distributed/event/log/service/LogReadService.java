package com.qather.distributed.event.log.service;

import com.qather.distributed.event.log.dto.LogResponse;
import com.qather.distributed.event.log.dto.SearchLogRequest;
import com.qather.distributed.event.log.out.adapter.LogReadAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LogReadService {
    private final LogReadAdapter logReadAdapter;

    public PageImpl<LogResponse.AccessLog> searchAccessLog(SearchLogRequest.AccessParam accessParam, Pageable pageable) {
        return logReadAdapter.searchAccessLog(accessParam, pageable);
    }

    public PageImpl<LogResponse.ActionLog> searchActionLog(SearchLogRequest.ActionParam actionParam, Pageable pageable) {
        return logReadAdapter.searchActionLog(actionParam, pageable);
    }

    public PageImpl<LogResponse.ErrorLog> searchErrorLog(SearchLogRequest.ErrorParam errorParam, Pageable pageable) {
        return logReadAdapter.searchErrorLog(errorParam, pageable);
    }
}
