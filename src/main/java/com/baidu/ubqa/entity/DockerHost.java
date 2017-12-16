package com.baidu.ubqa.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Data
public class DockerHost {
    @NotBlank
    private String ip;
    @Range(min=1, max=65536)
    private int port;

    public DockerHost(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    public String toURI(){
        return new StringBuilder("http://")
                .append(this.getIp())
                .append(":")
                .append(this.getPort())
                .toString();
    }

}
