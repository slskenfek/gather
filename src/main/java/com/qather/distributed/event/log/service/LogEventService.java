package com.qather.distributed.event.log.service;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;

public interface LogEventService {

    void createLog(LogParam param);


    void createActionLog(ActionParam param);


    void errorLog(ErrorParam param);
}
