package com.qather.distributed.api;

import com.qather.distributed.event.consumer.worker.LogWorkerService;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.QueueTask;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public ResponseEntity<String> createLog(@RequestBody LogParam logParam,
                                            @RequestBody ActionParam actionParam,
                                            @RequestBody ErrorParam errorParam
                                            ) {

        LogWorkerService.init(logParam, actionParam, errorParam);

        return ResponseEntity.ok("{'status' : 'success'}");
    }

}
