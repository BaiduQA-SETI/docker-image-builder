package com.baidu.ubqa.dockercommand;

/**
 * Created by zhaoming03 on 2017/12/8.
 */
public enum CommandMergeStrategy {
    NONE(0),
    BLOCK(1),
    WHOLE(2);

    private final int value;

    CommandMergeStrategy(int val) {
        this.value = val;
    }

    public int strategy() {
        return this.value;
    }

}
