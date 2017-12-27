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

package com.baidu.ubqa.processor.build;

import com.baidu.ubqa.client.DockerRemoteHandler;
import com.baidu.ubqa.config.RuntimeConfiguration;
import com.baidu.ubqa.entity.Image;
import com.baidu.ubqa.entity.ProcessorResult;
import com.baidu.ubqa.entity.Registry;
import com.baidu.ubqa.entity.Result;
import com.baidu.ubqa.processor.Processor;
import com.spotify.docker.client.DockerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CacheImageProcessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(CacheImageProcessor.class);

    @Override
    public ProcessorResult proceess(Image image, RuntimeConfiguration configuration) {
        if(configuration.getUsecache() && configuration.getCacheImage() != null){
            DockerRemoteHandler dockerRemoteHandler = new DockerRemoteHandler();
            Registry registry = configuration.getCacheImage().getRegistry();
            final DockerClient parentDockerClient = dockerRemoteHandler.buildDockerClient(registry, configuration.getDockerHost());
            Result result = dockerRemoteHandler.pull(parentDockerClient, configuration.getCacheImage());
            if(result.getStatus()){
                return new ProcessorResult(image,configuration).success();

            }else{
                logger.info("pull cache image failed, continue without cache image");
                return new ProcessorResult(image,configuration).success();
            }
        }else{
            return new ProcessorResult(image,configuration).success();
        }
    }
}
