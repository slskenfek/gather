package com.qather.distributed.event.log.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonLogManagerService {

    private final LogEventService logEventService;

    public void deleteAllLog(Boolean all) {
        logEventService.deleteAllLog(all);
    }
}
