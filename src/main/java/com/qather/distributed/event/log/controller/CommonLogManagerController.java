package com.qather.distributed.event.log.controller;

import com.qather.distributed.event.log.service.CommonLogManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/logs/combined")
@RequiredArgsConstructor
public class CommonLogManagerController {

    private final CommonLogManagerService commonLogManagerService;


    @DeleteMapping("")
    public ResponseEntity<Boolean> deleteLogAll(@RequestParam Boolean all) {
        commonLogManagerService.deleteAllLog(all);
        return ResponseEntity.ok(true);
    }
}
