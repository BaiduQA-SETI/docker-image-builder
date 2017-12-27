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

package com.baidu.ubqa.utils;

/**
 * Created by zhaoming03 on 2017/12/5.
 */
public class Constants {
    public static final String MERGER_SUPPORTED_BLOCK_LINE_SPLITER = "\r\n";
    public static final String FILE_LINE_BREAKER = "\n";
    public static final String DOCKER_COMMAND_BLOCK_LINE_SPLITER = " \\ ";
    public static final String DOCKER_COMMAND_BLOCK_LINE_JOINER = " && ";
    public static final String DEFAULT_FILE_ENCODING = "UTF-8";
    public static final String COMMAND_PARA_SPLITER = " ";
    public static final String ENV_PARA_SPLITER = "=";
    public static final String FILE_PATH_SPLITER = "/";
    public static final String DEFAULT_BUILD_USER = "root";

}
