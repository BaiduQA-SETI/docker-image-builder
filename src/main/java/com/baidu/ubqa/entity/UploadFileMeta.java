package com.baidu.ubqa.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by zhaoming03 on 2017/11/29.
 */
@Data
public class UploadFileMeta {
    @NotBlank
    private String fileName;
    @NotBlank
    private String destination;

    private boolean requireDecompress = true;
}
