package com.qather.distributed.event.log.service;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;

import java.util.List;

public interface LogEventService {

    void createLog(LogParam param);


    void createActionLog(ActionParam param);


    void createErrorLog(ErrorParam param);

    void bulkCreateLog(List<LogParam> param);


    void bulkCreateActionLog(List<ActionParam> param);


    void bulkCreateErrorLog(List<ErrorParam> param);
}
