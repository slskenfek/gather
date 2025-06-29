package com.qather.distributed.event.log;


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


    public boolean createLog(LogParam param) {
        logEventAdapter.createLog(param);
        return true;
    }

    public boolean createActionLog(ActionParam param) {
        logEventAdapter.createActionLog(param);
        return true;
    }

    public boolean errorLog(ErrorParam param) {
        logEventAdapter.errorLog(param);
        return true;
    }

}
