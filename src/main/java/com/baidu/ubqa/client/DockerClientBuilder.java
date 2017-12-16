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
