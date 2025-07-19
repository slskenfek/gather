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

import java.util.List;

@RequestMapping("/api/logs/action")
@RequiredArgsConstructor
@RestController
public class ActionLogController {

    private final LogReadService logReadService;


    @GetMapping("")
    public ResponseEntity<PageImpl<LogResponse.ActionLog>> searchActionLog(SearchLogRequest.ActionParam param, Pageable pageable) {
        PageImpl<LogResponse.ActionLog> responseAccessLog = logReadService.searchActionLog(param, pageable);
        return ResponseEntity.ok(responseAccessLog);
    }
    @GetMapping("/all")
    public ResponseEntity<List<LogResponse.ActionLog>> actionLogAll() {
        List<LogResponse.ActionLog> responseAccessLog = logReadService.selectAll();
        return ResponseEntity.ok(responseAccessLog);
    }

}
