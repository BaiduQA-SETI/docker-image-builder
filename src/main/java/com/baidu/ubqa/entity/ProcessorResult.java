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

import com.baidu.ubqa.config.RuntimeConfiguration;
import lombok.Data;

@Data
public class ProcessorResult {
    String info;
    Image image;
    RuntimeConfiguration configuration;
    Boolean status;


    public ProcessorResult(Image image, RuntimeConfiguration configuration){
        this.image = image;
        this.configuration = configuration;

    }

    public ProcessorResult(Image image, RuntimeConfiguration configuration, boolean status, String info){
        this.image = image;
        this.configuration = configuration;
        this.status = status;
        this.info = info;
    }

    public ProcessorResult error(String info) {
        this.status = false;
        this.info = info;
        return this;
    }

    public ProcessorResult success(Image image) {
        this.status = true;
        this.image = image;
        return this;
    }

    public ProcessorResult success() {
        this.status = true;
        return this;
    }
}
