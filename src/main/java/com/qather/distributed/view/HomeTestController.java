package com.qather.distributed.view;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class HomeTestController {


    private final static Logger log = LoggerFactory.getLogger(HomeTestController.class);

    @GetMapping("/log")
    public String logTestMove() {
        log.info("===로그 테스트 환경 접속===");
        return "queue/log_test";
    }

    @GetMapping("/log/tcp")
    public String tcpLogTestMove() {
        return "queue/tcp_test";
    }

    @GetMapping("/log/view")
    public String logViewMove() {
        return "queue/log_view";
    }


}
