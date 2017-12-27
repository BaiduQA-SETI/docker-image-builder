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

package com.baidu.ubqa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by zhaoming03 on 2017/12/4.
 */
@Data
public class Image extends ReadOnlyImage {
    @Valid
    private List<Port> ports;
    @Valid
    private List<EnvironmentVariable> envs;
    @Valid
    private List<Component> components;
    @Valid
    private List<UploadFile> files;
    @Valid
    private List<Script> integratedScript;
    @Valid
    private List<Script> runScript;
    @Valid
    private ReadOnlyImage baseImage;
    @NotBlank
    private String workdir;
    private String buildUser;
    private String runningUser;
    private String runningUserGroup;

    public List<EnvironmentVariable> getAllEnvs(){
        List<EnvironmentVariable> files = new ArrayList<>();
        if(!CollectionUtils.isEmpty(this.getComponents())){
            files =  this.getComponents().stream()
                    .map(component -> component.getEnvironmentVariables())
                    .flatMap(list -> list.stream()).collect(Collectors.toList());
        }
        //add image ports
        if(!CollectionUtils.isEmpty(this.getEnvs())){
            files.addAll(this.getEnvs());
        }
        return files;
    }

    public List<UploadFile> getAllFiles(){
        List<UploadFile> files = new ArrayList<>();
        if(!CollectionUtils.isEmpty(this.getComponents())){
            files =  this.getComponents().stream()
                    .map(component -> component.getFiles())
                    .flatMap(list -> list.stream()).collect(Collectors.toList());
        }
        //add image ports
        if(!CollectionUtils.isEmpty(this.getPorts())){
            files.addAll(this.getFiles());
        }
        return files;
    }

    public List<Port> getAllPorts(){
        List<Port> ports = new ArrayList<>();
        if(!CollectionUtils.isEmpty(this.getComponents())){
            ports =  this.getComponents().stream()
                    .map(component -> component.getPorts())
                    .flatMap(list -> list.stream()).collect(Collectors.toList());
        }
        //add image ports
        if(!CollectionUtils.isEmpty(this.getPorts())){
            ports.addAll(this.getPorts());
        }
        return ports;
    }

    public List<Script> getAllIntegratedScriptsByPriority(){
        return sortScriptByPriority(getAllIntegratedScripts());
    }
    public List<Script> getAllIntegratedScripts(){
        List<Script> scripts = new ArrayList<>();
        if(!CollectionUtils.isEmpty(this.getComponents())){
            scripts =  this.getComponents().stream()
                    .map(component -> component.getIntegratedScript())
                    .collect(Collectors.toList());
        }
        //add image IntegratedScript
        if(!CollectionUtils.isEmpty(this.getIntegratedScript())){
            scripts.addAll(this.getIntegratedScript());
        }
        return scripts;
    }

    public List<Script> getAllRunScriptsByPriority(){
        return sortScriptByPriority(getAllRunScripts());
    }

    public List<Script> getAllRunScripts(){
        List<Script> scripts = new ArrayList<>();
        if(!CollectionUtils.isEmpty(this.getComponents())){
            scripts =  this.getComponents().stream()
                    .map(component -> component.getRunScript())
                    .collect(Collectors.toList());
        }
        //add image RunScript
        if(!CollectionUtils.isEmpty(this.getRunScript())){
            scripts.addAll(this.getRunScript());
        }
        return sortScriptByPriority(scripts);
    }


    private List<Script> sortScriptByPriority(List<Script> scripts) {
        if ( !CollectionUtils.isEmpty(scripts) ){
            scripts = scripts.stream()
                    .sorted((p1, p2) -> p1.getPriority().compareTo(p2.getPriority()))
                    .collect(Collectors.toList());
            return scripts;
        }else {
            return null;
        }

    }
}
