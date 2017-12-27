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

import com.baidu.ubqa.entity.*;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public final class ComponentBuilder {
    private String name;
    private List<UploadFile> files;
    private List<Port> ports;
    private List<EnvironmentVariable> environmentVariables;
    private Script integratedScript;
    private Script runScript;

    private ComponentBuilder() {
    }

    public static ComponentBuilder aComponent() {
        return new ComponentBuilder();
    }

    public ComponentBuilder withName(String name) {
        this.name = name;
        return this;
    }


    public ComponentBuilder withFile(UploadFile file) {
        if(CollectionUtils.isEmpty(this.files)) {
            this.files = new ArrayList<>();
        }
        this.files.add(file);
        return this;
    }

    public ComponentBuilder withFiles(List<UploadFile> files) {
        this.files = files;
        return this;
    }

    public ComponentBuilder withPort(Port port) {
        if(CollectionUtils.isEmpty(this.ports)) {
            this.ports = new ArrayList<>();
        }
        this.ports.add(port);
        return this;
    }

    public ComponentBuilder withPorts(List<Port> ports) {
        this.ports = ports;
        return this;
    }

    public ComponentBuilder withEnvironmentVariables(List<EnvironmentVariable> environmentVariables) {
        this.environmentVariables = environmentVariables;
        return this;
    }

    public ComponentBuilder withEnvironmentVariable(EnvironmentVariable environmentVariable) {
        if(CollectionUtils.isEmpty(this.environmentVariables)) {
            this.environmentVariables = new ArrayList<>();
        }
        this.environmentVariables.add(environmentVariable);
        return this;
    }

    public ComponentBuilder withIntegratedScript(Script integratedScript) {
        this.integratedScript = integratedScript;
        return this;
    }

    public ComponentBuilder withRunScript(Script runScript) {
        this.runScript = runScript;
        return this;
    }

    public Component build() {
        Component component = new Component();
        component.setName(name);
        component.setFiles(files);
        component.setPorts(ports);
        component.setEnvironmentVariables(environmentVariables);
        component.setIntegratedScript(integratedScript);
        component.setRunScript(runScript);
        return component;
    }
}
