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
