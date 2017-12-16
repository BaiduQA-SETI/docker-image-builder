package com.baidu.ubqa.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by zhaoming03 on 2017/12/4.
 */
@Data
public class ReadOnlyImage {
    @NotBlank
    private String namespace;
    @NotBlank
    private String name;
    @NotBlank
    private String tag;
    @Valid
    private Registry registry;
    private String comment;

    public String getRepository(){
        return new StringBuilder()
                .append(this.getRegistry().getServerAddress())
                .append("/")
                .append(this.getNamespace())
                .append("/")
                .append(this.getName())
                .append(":")
                .append(this.getTag())
                .toString();
    }

}
