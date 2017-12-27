/*
 *  docker-image-builder
 *  --
 *  Copyright (c) 2016 Baidu, Inc. All Rights Reserved.
 *  --
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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
