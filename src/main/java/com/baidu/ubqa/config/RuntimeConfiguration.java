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

package com.baidu.ubqa.config;

import com.baidu.ubqa.entity.DockerHost;
import com.baidu.ubqa.entity.ReadOnlyImage;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data

public class RuntimeConfiguration {
    @Valid
    private DockerHost dockerHost;
    @NotBlank
    private String workspace;
    private Long connectTimeout = 5000l;
    private Long readTimeout = 9000l ;
    private Integer retrytimes =3;
    private Boolean usecache = false;
    @Valid
    private ReadOnlyImage cacheImage;
    private Boolean postClean = true;
}
