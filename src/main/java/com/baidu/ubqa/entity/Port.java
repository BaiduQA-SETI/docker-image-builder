package com.baidu.ubqa.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * Created by zhaoming03 on 2017/11/29.
 */
@Data
public class Port {
    @NotBlank
    private String name;
    @Range(min=1, max=65536)
    private int port;

    public Port(String name, int port) {
        this.name = name;
        this.port = port;
    }
}
