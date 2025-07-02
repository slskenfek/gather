package com.qather.distributed.event.log.dto;

import com.qather.distributed.event.users.out.entity.Users;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class LogResponse {


    public static class AccessLog {

        private Long id;

        private Users users;

        private String payload;

        private String type;

        private LocalDateTime time;

    }

    public static class ActionLog {

        private Long id;

        private String url;

        private String content;

        private Users users;

        private LocalDateTime time;

    }

    public static class ErrorLog {

        private Long id;

        private String code;

        private String stace;

        private String errorMsg;

        private Users users;

        private LocalDateTime time;

    }
}
