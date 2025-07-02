package com.qather.distributed.event.log.service;

import com.qather.distributed.event.log.dto.LogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LogFindService {


    public LogResponse.AccessLog searchAccessLog() {

    }
}
