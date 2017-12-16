package com.baidu.ubqa.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UploadFile extends UploadFileMeta {
    @NotBlank
    private String path;
}
