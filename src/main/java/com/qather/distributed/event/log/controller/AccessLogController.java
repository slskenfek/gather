package com.qather.distributed.event.log.controller;


import com.qather.distributed.event.log.dto.LogResponse;
import com.qather.distributed.event.log.service.LogFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs/access")
@RequiredArgsConstructor
public class AccessLogController {

    private final LogFindService logFindService;

    @GetMapping("")
    public ResponseEntity<LogResponse.AccessLog> searchAccessLog() {
        LogResponse.AccessLog response = logFindService.searchAccessLog();
        return ResponseEntity.ok(response);
    }
}
