package com.baidu.ubqa.entity;

import java.util.List;


import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by zhaoming03 on 2017/11/29.
 */

@Data
public class Component {

    @NotBlank
    private String name;

    private List<UploadFile> files;

    private List<Port> ports;

    private List<EnvironmentVariable> environmentVariables;

    private Script integratedScript;

    private Script runScript;

}
