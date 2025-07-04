package com.qather.distributed.event.log.controller;

import com.qather.distributed.event.log.dto.LogResponse;
import com.qather.distributed.event.log.dto.SearchLogRequest;
import com.qather.distributed.event.log.service.LogReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/logs/error")
@RequiredArgsConstructor
@RestController
public class ErrorLogController {
    private final LogReadService logReadService;


    @GetMapping("")
    public ResponseEntity<PageImpl<LogResponse.ErrorLog>> searchErrorLog(@RequestParam SearchLogRequest.ErrorParam param, Pageable pageable) {
        PageImpl<LogResponse.ErrorLog> responseAccessLog = logReadService.searchErrorLog(param, pageable);
        return ResponseEntity.ok(responseAccessLog);
    }
}
