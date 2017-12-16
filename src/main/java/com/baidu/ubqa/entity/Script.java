package com.baidu.ubqa.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * Created by zhaoming03 on 2017/11/29.
 */
@Data
public class Script implements Comparable<Script> {
    @NotBlank
    private String command;

    // TODO add other type
    private Integer type = ScriptType.SHELL.getValue();

    private Integer priority = 100;

    public Script() {
        this.command = command;
    }

    public Script(String command) {
        this.command = command;
    }

    public Script(String command, Integer priority) {
        this.command = command;
        this.priority = priority;
    }

    public int compareTo(Script o) {
        return this.getPriority().compareTo(o.getPriority());
    }
}
