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
