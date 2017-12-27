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

import com.baidu.ubqa.config.RuntimeConfiguration;
import com.baidu.ubqa.entity.DockerHost;
import com.baidu.ubqa.entity.ReadOnlyImage;

public final class RuntimeConfigurationBuilder {
    private DockerHost dockerHost;
    private String workspace;
    private Long connectTimeout = 5000l;
    private Long readTimeout = 9000l ;
    private Integer retrytimes =3;
    private Boolean usecache = false;
    private ReadOnlyImage cacheImage;
    private Boolean postClean = true;

    private RuntimeConfigurationBuilder() {
    }

    public static RuntimeConfigurationBuilder aRuntimeConfiguration() {
        return new RuntimeConfigurationBuilder();
    }

    public RuntimeConfigurationBuilder withDockerHost(DockerHost dockerHost) {
        this.dockerHost = dockerHost;
        return this;
    }

    public RuntimeConfigurationBuilder withWorkspace(String workspace) {
        this.workspace = workspace;
        return this;
    }

    public RuntimeConfigurationBuilder withConnectTimeout(Long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public RuntimeConfigurationBuilder withReadTimeout(Long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public RuntimeConfigurationBuilder withRetrytimes(Integer retrytimes) {
        this.retrytimes = retrytimes;
        return this;
    }

    public RuntimeConfigurationBuilder withUsecache(Boolean usecache) {
        this.usecache = usecache;
        return this;
    }

    public RuntimeConfigurationBuilder withCacheImage(ReadOnlyImage cacheImage) {
        this.cacheImage = cacheImage;
        return this;
    }

    public RuntimeConfigurationBuilder withPostClean(Boolean postClean) {
        this.postClean = postClean;
        return this;
    }

    public RuntimeConfiguration build() {
        RuntimeConfiguration runtimeConfiguration = new RuntimeConfiguration();
        runtimeConfiguration.setDockerHost(dockerHost);
        runtimeConfiguration.setWorkspace(workspace);
        runtimeConfiguration.setConnectTimeout(connectTimeout);
        runtimeConfiguration.setReadTimeout(readTimeout);
        runtimeConfiguration.setRetrytimes(retrytimes);
        runtimeConfiguration.setUsecache(usecache);
        runtimeConfiguration.setCacheImage(cacheImage);
        runtimeConfiguration.setPostClean(postClean);
        return runtimeConfiguration;
    }
}
