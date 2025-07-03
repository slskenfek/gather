package com.qather.distributed.event.log.dto;

import com.qather.distributed.event.users.out.entity.Users;
import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class LogResponse {


    @Getter
    @NoArgsConstructor
    public static class AccessLog {

        private Long id;

        private String userId;

        private String payload;

        private String type;

        private LocalDateTime time;

        @QueryProjection
        public AccessLog(Long id, String userId, String payload, String type, LocalDateTime time) {
            this.id = id;
            this.userId = userId;
            this.payload = payload;
            this.type = type;
            this.time = time;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class ActionLog {

        private Long id;

        private String url;

        private String content;

        private String userId;

        private LocalDateTime time;

        @QueryProjection
        public ActionLog(Long id, String url, String content, String userId, LocalDateTime time) {
            this.id = id;
            this.url = url;
            this.content = content;
            this.userId = userId;
            this.time = time;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class ErrorLog {

        private Long id;

        private String code;

        private String stace;

        private String errorMsg;

        private String userId;

        private LocalDateTime time;

        @QueryProjection
        public ErrorLog(Long id, String code, String stace, String errorMsg, String userId, LocalDateTime time) {
            this.id = id;
            this.code = code;
            this.stace = stace;
            this.errorMsg = errorMsg;
            this.userId = userId;
            this.time = time;
        }
    }
}
