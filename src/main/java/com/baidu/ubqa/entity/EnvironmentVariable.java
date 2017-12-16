package com.baidu.ubqa.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by zhaoming03 on 2017/11/29.
 */
@Data
public class EnvironmentVariable {
    @NotBlank
    private String name;
    @NotBlank
    private String value;

    public EnvironmentVariable(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
