package com.baidu.ubqa.builder;

import com.baidu.ubqa.entity.Script;
import com.baidu.ubqa.entity.ScriptType;

public final class ScriptBuilder {
    private String command;
    // TODO add other type
    private Integer type = ScriptType.SHELL.getValue();
    private Integer priority = 100;

    private ScriptBuilder() {
    }

    public static ScriptBuilder aScript() {
        return new ScriptBuilder();
    }

    public ScriptBuilder withCommand(String command) {
        this.command = command;
        return this;
    }

    public ScriptBuilder withType(Integer type) {
        this.type = type;
        return this;
    }

    public ScriptBuilder withPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public Script build() {
        Script script = new Script();
        script.setCommand(command);
        script.setType(type);
        script.setPriority(priority);
        return script;
    }
}
