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

package com.baidu.ubqa.entity;

import lombok.Data;

@Data
public class Result {
    private Object data;
    private Boolean status;
    private String info;


    public Result success(Object data) {
        this.setStatus(true);
        this.setData(data);
        this.setInfo("");
        return this;
    }

    public Result success() {
        this.setStatus(true);
        this.setInfo("");
        this.setData("");
        return this;
    }


    public Result fail(Object data,String errorMessage) {
        this.setStatus(false);
        this.setData(data);
        this.setInfo(errorMessage);
        return this;
    }

    public Result fail(String errorMessage) {
        this.setStatus(false);
        this.setInfo(errorMessage);
        return this;
    }
}
