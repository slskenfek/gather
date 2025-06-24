package com.qather.distributed.event.task.model;

import lombok.Getter;


public enum TaskType {

    MEM("mem"),
    ;

    private String taskCode;

    TaskType(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskCode() {
        return taskCode;
    }
}
