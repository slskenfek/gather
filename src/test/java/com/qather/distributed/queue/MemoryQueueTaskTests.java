package com.qather.distributed.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.log.dto.LogRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MemoryQueueTaskTests {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("메모리 큐에 순차적으로 적재 한다.")
    void test() throws Exception {
        LogParam logParam = new LogParam("some-url", "some-content", "user1", LocalDateTime.now());
        ActionParam actionParam = new ActionParam("click", "home", "some-url", LocalDateTime.now());
        ErrorParam errorParam = new ErrorParam("A-001", "NullPointerException", "stacktrace...", "some-url", LocalDateTime.now());
        LogRequest request = new LogRequest(logParam, actionParam, errorParam);


        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/v1/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("{'status' : 'success'}"));

    }
}
