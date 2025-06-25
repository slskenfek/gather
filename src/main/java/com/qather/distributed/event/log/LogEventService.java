package com.qather.distributed.event.log;


import com.qather.distributed.event.log.out.adapter.LogEventAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogEventService {
    private final LogEventAdapter logEventAdapter;



}
