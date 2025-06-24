package com.qather.distributed.api;


import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.task.dto.MemoryTaskParam;
import com.qather.distributed.event.task.model.QueueTask;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogController {


    private final QueueTask<LogParam> queueTask;

    public LogController(@Qualifier(value = "logQueue") QueueTask<LogParam> queueTask) {
        this.queueTask = queueTask;
    }

    @PostMapping("/v1/log")
    public ResponseEntity<String> createLog(@RequestBody LogParam param) {
        queueTask.enqueueTask(param);

        return ResponseEntity.ok("{'status' : 'success'}");
    }

}
