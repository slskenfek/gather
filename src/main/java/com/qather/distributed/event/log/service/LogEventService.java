package com.qather.distributed.event.log.service;


import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.log.out.adapter.DatabaseLogAdapter;

import com.qather.distributed.event.log.out.adapter.LogEventAdapter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogEventService {


    private final LogEventAdapter logEventAdapter;

    public LogEventService(@Qualifier("databaseLogAdapter") LogEventAdapter logEventAdapter) {
        this.logEventAdapter = logEventAdapter;
    }

    private static Logger LOGGER = LoggerFactory.getLogger(DatabaseLogAdapter.class);


    @Async("logExecutor")
    public void createLog(LogParam param) {
        logEventAdapter.createLog(param);
        //TODO 엘라스틱 서치 저장 로직 필요
    }

    @Async("logExecutor")
    public void createActionLog(ActionParam param) {
        logEventAdapter.createActionLog(param);
        //TODO 엘라스틱 서치 저장 로직 필요
    }

    @Async("logExecutor")
    public void errorLog(ErrorParam param) {
        logEventAdapter.errorLog(param);
        //TODO 엘라스틱 서치 저장 로직 필요
    }

}
