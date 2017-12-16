package com.baidu.ubqa.builder;

import com.baidu.ubqa.entity.Registry;

public final class RegistryBuilder {
    private Registry registry;

    private RegistryBuilder() {
        registry = new Registry();
    }

    public static RegistryBuilder aRegistry() {
        return new RegistryBuilder();
    }

    public RegistryBuilder withUsername(String username) {
        registry.setUsername(username);
        return this;
    }

    public RegistryBuilder withPassword(String password) {
        registry.setPassword(password);
        return this;
    }

    public RegistryBuilder withEmail(String email) {
        registry.setEmail(email);
        return this;
    }

    public RegistryBuilder withServerAddress(String serverAddress) {
        registry.setServerAddress(serverAddress);
        return this;
    }

    public Registry build() {
        return registry;
    }
}
