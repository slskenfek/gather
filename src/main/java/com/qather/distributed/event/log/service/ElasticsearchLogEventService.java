package com.qather.distributed.event.log.service;


import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.log.out.adapter.ElasticsearchLogAdapter;
import com.qather.distributed.event.log.out.adapter.LogEventAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElasticsearchLogEventService implements LogEventService {


    private final LogEventAdapter logEventAdapter;

    public ElasticsearchLogEventService(ElasticsearchLogAdapter elasticsearchLogAdapter) {
        this.logEventAdapter = elasticsearchLogAdapter;
    }

    @Override
    public void createLog(LogParam param) {
        logEventAdapter.createLog(param);
    }

    @Override
    public void createActionLog(ActionParam param) {
        logEventAdapter.createActionLog(param);
    }


    @Override
    public void createErrorLog(ErrorParam param) {
        logEventAdapter.errorLog(param);
    }

    @Override
    public void bulkCreateErrorLog(List<ErrorParam> param) {

    }

    @Override
    public void bulkCreateLog(List<LogParam> param) {

    }

    @Override
    public void bulkCreateActionLog(List<ActionParam> param) {

    }
}
