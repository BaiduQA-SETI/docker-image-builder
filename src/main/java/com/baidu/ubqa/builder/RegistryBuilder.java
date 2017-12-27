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
