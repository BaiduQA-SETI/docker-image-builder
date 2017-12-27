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

package com.baidu.ubqa.dockercommand;

import com.baidu.ubqa.utils.Constants;
import com.baidu.ubqa.entity.Script;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EntrypointBuilder {

    private Logger logger = LoggerFactory.getLogger(EntrypointBuilder.class);

    public String makeEntrypoint(List<Script> scripts) {
        StringBuilder entrypoint = new StringBuilder();
        entrypoint.append("#! /bin/bash").append(Constants.FILE_LINE_BREAKER);
        for(Script script : scripts) {
            String block = script.getCommand().replaceAll(Constants.MERGER_SUPPORTED_BLOCK_LINE_SPLITER,Constants.FILE_LINE_BREAKER);
            entrypoint.append(block).append(Constants.FILE_LINE_BREAKER);
        }
        logger.info("entrypoint.sh:{}",entrypoint.toString());
        return entrypoint.toString();
    }


}
