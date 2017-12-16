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
