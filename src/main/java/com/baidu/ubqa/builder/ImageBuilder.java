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

public final class ImageBuilder {
    private String namespace;
    private String name;
    private String tag;
    private Registry registry;
    private String comment;
    private List<Port> ports;
    private List<EnvironmentVariable> envs;
    private List<Component> components;
    private List<UploadFile> files;
    private List<Script> integratedScript;
    private List<Script> runScript;
    private ReadOnlyImage baseImage;
    private String workdir;
    private String buildUser;
    private String runningUser;
    private String runningUserGroup;

    private ImageBuilder() {
    }

    public static ImageBuilder anImage() {
        return new ImageBuilder();
    }

    public ImageBuilder withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public ImageBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ImageBuilder withTag(String tag) {
        this.tag = tag;
        return this;
    }

    public ImageBuilder withRegistry(Registry registry) {
        this.registry = registry;
        return this;
    }

    public ImageBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }


    public ImageBuilder withPort(Port port) {
        if(CollectionUtils.isEmpty(this.ports)) {
            this.files = new ArrayList<>();
        }
        this.ports.add(port);
        return this;
    }

    public ImageBuilder withPorts(List<Port> ports) {
        this.ports = ports;
        return this;
    }

    public ImageBuilder withEnvironmentVariable(EnvironmentVariable environmentVariable) {
        if(CollectionUtils.isEmpty(this.envs)) {
            this.envs = new ArrayList<>();
        }
        this.envs.add(environmentVariable);
        return this;
    }

    public ImageBuilder withEnvironmentVariables(List<EnvironmentVariable> envs) {
        this.envs = envs;
        return this;
    }

    public ImageBuilder withComponent(Component component) {
        if(CollectionUtils.isEmpty(this.components)){
            this.components = new ArrayList<>();
        }
        this.components.add(component);
        return this;
    }

    public ImageBuilder withComponents(List<Component> components) {
        this.components = components;
        return this;
    }

    public ImageBuilder withFile(UploadFile file) {
        if(CollectionUtils.isEmpty(this.files)) {
            this.files = new ArrayList<>();
        }
        this.files.add(file);
        return this;
    }

    public ImageBuilder withFiles(List<UploadFile> files) {
        this.files = files;
        return this;
    }

    public ImageBuilder withIntegratedScript(Script integratedScript) {
        if(CollectionUtils.isEmpty(this.integratedScript)) {
            this.integratedScript = new ArrayList<>();
        }
        this.integratedScript.add(integratedScript);
        return this;
    }

    public ImageBuilder withIntegratedScript(List<Script> integratedScript) {
        this.integratedScript = integratedScript;
        return this;
    }

    public ImageBuilder withRunScript(Script runScript) {
        if(CollectionUtils.isEmpty(this.runScript)) {
            this.runScript = new ArrayList<>();
        }
        this.runScript.add(runScript);
        return this;
    }

    public ImageBuilder withRunScript(List<Script> runScript) {
        this.runScript = runScript;
        return this;
    }

    public ImageBuilder withBaseImage(ReadOnlyImage baseImage) {
        this.baseImage = baseImage;
        return this;
    }

    public ImageBuilder withWorkdir(String workdir) {
        this.workdir = workdir;
        return this;
    }

    public ImageBuilder withBuildUser(String buildUser) {
        this.buildUser = buildUser;
        return this;
    }

    public ImageBuilder withRunningUser(String runningUser) {
        this.runningUser = runningUser;
        return this;
    }

    public ImageBuilder withRunningUserGroup(String runningUserGroup) {
        this.runningUserGroup = runningUserGroup;
        return this;
    }

    public Image build() {
        Image image = new Image();
        image.setNamespace(namespace);
        image.setName(name);
        image.setTag(tag);
        image.setRegistry(registry);
        image.setComment(comment);
        image.setPorts(ports);
        image.setEnvs(envs);
        image.setComponents(components);
        image.setFiles(files);
        image.setIntegratedScript(integratedScript);
        image.setRunScript(runScript);
        image.setBaseImage(baseImage);
        image.setWorkdir(workdir);
        image.setBuildUser(buildUser);
        image.setRunningUser(runningUser);
        image.setRunningUserGroup(runningUserGroup);
        return image;
    }
}
