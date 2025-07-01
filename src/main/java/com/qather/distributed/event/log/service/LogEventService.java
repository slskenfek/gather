package com.qather.distributed.event.log.service;


import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.log.out.adapter.LogEventAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogEventService {
    private final LogEventAdapter logEventAdapter;


    public void createLog(LogParam param) {
        logEventAdapter.createLog(param);
    }

    public void createActionLog(ActionParam param) {
        logEventAdapter.createActionLog(param);
    }

    public void errorLog(ErrorParam param) {
        logEventAdapter.errorLog(param);
    }

}
