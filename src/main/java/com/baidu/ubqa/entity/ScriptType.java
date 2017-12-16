package com.baidu.ubqa.entity;

/**
 * Created by zhaoming03 on 2017/12/8.
 */
public enum ScriptType {
    SHELL(0);

    private final int value;

    ScriptType(int val) {
        this.value = val;
    }

    public int getValue() {
        return this.value;
    }
}
