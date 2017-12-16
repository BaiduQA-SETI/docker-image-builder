package com.baidu.ubqa.entity;

import com.baidu.ubqa.config.RuntimeConfiguration;
import lombok.Data;

@Data
public class ProcessorResult {
    String info;
    Image image;
    RuntimeConfiguration configuration;
    Boolean status;


    public ProcessorResult(Image image, RuntimeConfiguration configuration){
        this.image = image;
        this.configuration = configuration;

    }

    public ProcessorResult(Image image, RuntimeConfiguration configuration, boolean status, String info){
        this.image = image;
        this.configuration = configuration;
        this.status = status;
        this.info = info;
    }

    public ProcessorResult error(String info) {
        this.status = false;
        this.info = info;
        return this;
    }

    public ProcessorResult success(Image image) {
        this.status = true;
        this.image = image;
        return this;
    }

    public ProcessorResult success() {
        this.status = true;
        return this;
    }
}
