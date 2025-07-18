package com.qather.distributed.tcp.dispatcher;

import com.qather.distributed.event.log.dto.ActionParam;
import com.qather.distributed.event.log.dto.ErrorParam;
import com.qather.distributed.event.log.dto.LogParam;
import com.qather.distributed.event.producer.model.QueueFactory;
import com.qather.distributed.event.producer.model.QueueTask;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class TcpMessageDispatcher {

    private final QueueTask<LogParam> logQueue = QueueFactory.getLogQueue();
    private final QueueTask<ErrorParam> errorQueue = QueueFactory.getErrorQueue();
    private final QueueTask<ActionParam> actionQueue = QueueFactory.getActionQueue();


    private static final Logger LOGGER = LoggerFactory.getLogger(TcpMessageDispatcher.class);

    /**
     * 추후 전략 패턴 고려
     *
     * @param tcpParam
     */
    public void dispatch(Map<String, Object> tcpParam) {
        if (tcpParam == null) {
            return;
        }
        String type = (String) tcpParam.get("type");


        switch (type) {
            case "error" -> {
                ErrorParam errorParam = new ErrorParam(
                        String.valueOf(tcpParam.get("code")),
                        String.valueOf(tcpParam.get("stace")),
                        String.valueOf(tcpParam.get("errorMsg")),
                        String.valueOf(tcpParam.get("userId")),
                        LocalDateTime.now()
                );
                errorQueue.createTask(errorParam);
            }
            case "action" -> {
                ActionParam actionParam = new ActionParam(
                        String.valueOf(tcpParam.get("url")),
                        String.valueOf(tcpParam.get("content")),
                        String.valueOf(tcpParam.get("userId")),
                        LocalDateTime.now()
                );
                actionQueue.createTask(actionParam);
            }
            case "access" -> {
                LogParam logParam = new LogParam(
                        String.valueOf(tcpParam.get("userId")),
                        String.valueOf(tcpParam.get("type")),
                        String.valueOf(tcpParam.get("payload")),
                        LocalDateTime.now()
                );
                logQueue.createTask(logParam);
            }
            default -> LOGGER.error("알수없는 타입? {} ", type);
        }


    }
}
