package com.qather.distributed.event.producer.model;


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
