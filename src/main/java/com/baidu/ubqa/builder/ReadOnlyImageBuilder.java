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

import com.baidu.ubqa.entity.ReadOnlyImage;
import com.baidu.ubqa.entity.Registry;

/**
 * Created by zhaoming03 on 2017/12/4.
 */
public final class ReadOnlyImageBuilder {
    private String namespace;
    private String name;
    private String tag;
    private Registry registry;

    private ReadOnlyImageBuilder() {
    }

    public static ReadOnlyImageBuilder aReadOnlyImage() {
        return new ReadOnlyImageBuilder();
    }

    public ReadOnlyImageBuilder withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public ReadOnlyImageBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ReadOnlyImageBuilder withTag(String tag) {
        this.tag = tag;
        return this;
    }

    public ReadOnlyImageBuilder withRegistry(Registry registry) {
        this.registry = registry;
        return this;
    }

    public ReadOnlyImage build() {
        ReadOnlyImage readOnlyImage = new ReadOnlyImage();
        readOnlyImage.setNamespace(namespace);
        readOnlyImage.setName(name);
        readOnlyImage.setTag(tag);
        readOnlyImage.setRegistry(registry);
        return readOnlyImage;
    }
}
