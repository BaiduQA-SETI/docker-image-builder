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
