/*
 *  docker-image-builder
 *  --
 *  Copyright (c) 2016 Baidu, Inc. All Rights Reserved.
 *  --
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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
