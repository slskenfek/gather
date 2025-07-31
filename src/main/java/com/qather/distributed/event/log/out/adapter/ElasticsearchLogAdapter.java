package com.qather.distributed.event.log.out.adapter;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.log.out.entity.AccessLogDocument;
import com.qather.distributed.event.log.out.repository.LogElasticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ElasticsearchLogAdapter implements LogEventAdapter {


    private final LogElasticRepository logElasticRepository;

    @Override
    public void deleteAllAccessLog() {
        //TODO deleteAll
    }

    @Override
    public void createLog(LogParam param) {
        AccessLogDocument doc = AccessLogDocument.builder()
                .id(UUID.randomUUID().toString())
                .type(param.getType()) // access, action, error 등
                .userId(param.getUserId())
                .payload(param.getPayload())
                .time(LocalDateTime.now())
                .build();

        logElasticRepository.save(doc);
    }

    @Override
    public void createActionLog(ActionParam param) {

    }

    @Override
    public void errorLog(ErrorParam param) {

    }
}
