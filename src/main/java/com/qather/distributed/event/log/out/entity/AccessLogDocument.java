package com.qather.distributed.event.log.out.entity;

import com.qather.distributed.event.users.out.entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Document(indexName = "log-index")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessLogDocument {
    @Id
    private String id;

    private String userId;

    private String payload;

    private String type;

    private String logType;

    private LocalDateTime time;

}
