package com.baidu.ubqa.builder;

import com.baidu.ubqa.entity.UploadFile;

public final class UploadFileBuilder {
    private String path;
    private String fileName;
    private String destination;
    private boolean requireDecompress = false;

    private UploadFileBuilder() {
    }

    public static UploadFileBuilder anUploadFile() {
        return new UploadFileBuilder();
    }

    public UploadFileBuilder withPath(String path) {
        this.path = path;
        return this;
    }

    public UploadFileBuilder withFileName(String file) {
        this.fileName = file;
        return this;
    }

    public UploadFileBuilder withDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public UploadFileBuilder withRequireDecompress(boolean requireDecompress) {
        this.requireDecompress = requireDecompress;
        return this;
    }

    public UploadFile build() {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setPath(path);
        uploadFile.setFileName(fileName);
        uploadFile.setDestination(destination);
        uploadFile.setRequireDecompress(requireDecompress);
        return uploadFile;
    }
}
