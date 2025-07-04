package com.qather.distributed.event.log.out.adapter;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ElasticsearchLogAdapter implements LogEventAdapter {

    @Override
    public void createLog(LogParam param) {

    }

    @Override
    public void createActionLog(ActionParam param) {

    }

    @Override
    public void errorLog(ErrorParam param) {

    }
}
