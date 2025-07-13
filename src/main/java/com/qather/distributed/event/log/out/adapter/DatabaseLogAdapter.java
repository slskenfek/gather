package com.qather.distributed.event.log.out.adapter;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.log.out.repository.ActionRepository;
import com.qather.distributed.event.log.out.repository.ErrorRepository;
import com.qather.distributed.event.log.out.repository.AccessLogReadRepository;
import com.qather.distributed.event.log.out.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseLogAdapter implements LogEventAdapter {

    private final LogRepository logRepository;

    private final ActionRepository actionRepository;

    private final ErrorRepository errorRepository;


    @Override
    public void createLog(LogParam param) {
        logRepository.save(param.toAccessLogEntity());
    }

    @Override
    public void createActionLog(ActionParam param) {
        actionRepository.save(param.toActionLogEntity());
    }

    @Override
    public void errorLog(ErrorParam param) {
        errorRepository.save(param.toErrorLogEntity());
    }
}
