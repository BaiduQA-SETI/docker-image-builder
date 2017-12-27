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

package com.baidu.ubqa.processor.prebuild;

import com.baidu.ubqa.config.RuntimeConfiguration;
import com.baidu.ubqa.dockerfile.DockerFileMaker;
import com.baidu.ubqa.entity.Image;
import com.baidu.ubqa.entity.ProcessorResult;
import com.baidu.ubqa.processor.Processor;
import com.baidu.ubqa.utils.Constants;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class DockerFileProcessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(DockerFileProcessor.class);

    @Override
    public ProcessorResult proceess(Image image, RuntimeConfiguration configuration) {
        DockerFileMaker dockerFileMaker = new DockerFileMaker();
        String fileContent = dockerFileMaker.makeFileContent(image);
        try {
            FileUtils.write(new File(String.format("%s/dockerfile", configuration.getWorkspace())), fileContent, Constants.DEFAULT_FILE_ENCODING);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("cannot write to {}", String.format("%s/dockerfile", configuration.getWorkspace()));
            return new ProcessorResult(image, configuration).error(String.format("cannot write to fileName %s/dockerfile", configuration.getWorkspace()));
        }
        return new ProcessorResult(image, configuration).success();
    }
}
