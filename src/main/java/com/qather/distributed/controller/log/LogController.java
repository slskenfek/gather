package com.qather.distributed.controller.log;

import com.qather.distributed.event.consumer.worker.LogWorkerService;
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

    private final LogWorkerService logWorkerService;


    @PostMapping("/v1/log")
    public ResponseEntity<String> createLog(@RequestBody LogRequest request) {
        logWorkerService.createLogQueue(request.getLogParam(), request.getActionParam(), request.getErrorParam());
        return ResponseEntity.ok("{'status' : 'success'}");
    }

}
