package com.qather.distributed.api;


import com.qather.distributed.event.task.dto.TaskParam;
import com.qather.distributed.event.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @PostMapping("/v1/task")
    public ResponseEntity<String> createTask(@RequestBody TaskParam param) {
        taskService.enqueueTask(param);

        return ResponseEntity.ok("{'status' : 'success'}");
    }

}
