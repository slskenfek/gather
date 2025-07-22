package com.qather.distributed.event.producer.controller.log;

import com.qather.distributed.event.producer.handler.LogQueueDaemon;
import com.qather.distributed.event.log.dto.LogRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LogController {

    private final LogQueueDaemon logQueueDaemon;


    @PostMapping("/v1/log")
    public ResponseEntity<String> createLog(@RequestBody LogRequest request) {
        logQueueDaemon.createLogQueue(request.getLogParam(), request.getActionParam(), request.getErrorParam());
        return ResponseEntity.ok("{'status' : 'success'}");
    }

}
