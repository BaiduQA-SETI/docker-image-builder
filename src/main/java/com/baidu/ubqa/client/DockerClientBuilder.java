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

package com.baidu.ubqa.client;

import com.baidu.ubqa.entity.Registry;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;

/**
 * Created by zhaoming03 on 2017/12/5.
 */
public class DockerClientBuilder {
    DockerClient build(Registry registry, String dockerHost, long connectTimeout, long readTimeout) {
        final DockerClient dockerClient = DefaultDockerClient.builder()
                .authConfig(registry.toAuthConfig())
                .uri(dockerHost)
                .connectTimeoutMillis(connectTimeout)
                .readTimeoutMillis(readTimeout)
                .build();
        return dockerClient;
    }
}
