package com.qather.distributed.event.log.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class SearchLogRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class AccessParam {
        private String userId;
        private String type;
        private String payload;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ActionParam {
        private String url;
        private String content;
        private String userId;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ErrorParam {
        private String code;
        private String stace;
        private String errorMsg;
        private String userId;
    }

}
