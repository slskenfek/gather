package com.qather.distributed.event.log.out.adapter;

import com.qather.distributed.event.log.out.repository.LogReadRepository;
import com.qather.distributed.event.log.out.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogEventAdapter {

    private final LogReadRepository readRepository;
    private final LogRepository logRepository;



}
