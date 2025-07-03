package com.qather.distributed.event.log.out.adapter;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.log.out.repository.ActionRepository;
import com.qather.distributed.event.log.out.repository.ErrorRepository;
import com.qather.distributed.event.log.out.repository.AccessLogReadRepository;
import com.qather.distributed.event.log.out.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogEventAdapter {

    private final AccessLogReadRepository readRepository;
    private final LogRepository logRepository;

    private final ActionRepository actionRepository;

    private final ErrorRepository errorRepository;


    public void createLog(LogParam param) {
        logRepository.save(param.toAccessLogEntity());
    }


    public void createActionLog(ActionParam param) {
        actionRepository.save(param.toActionLogEntity());
    }

    public void errorLog(ErrorParam param) {
        errorRepository.save(param.toErrorLogEntity());
    }
}
