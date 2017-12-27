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
import com.baidu.ubqa.entity.Image;
import com.baidu.ubqa.entity.ProcessorResult;
import com.baidu.ubqa.entity.UploadFile;
import com.baidu.ubqa.processor.Processor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileCopyProcessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(FileCopyProcessor.class);

    @Override
    public ProcessorResult proceess(Image image, RuntimeConfiguration configuration) {
        List<UploadFile> files =  image.getAllFiles();
        if(!CollectionUtils.isEmpty(files)){
            for(UploadFile file : files) {
                if(!configuration.getWorkspace().equals(file.getPath())) {
                    try {

                        FileUtils.copyFileToDirectory(new File(file.getPath()+"/"+file.getFileName()), new File(configuration.getWorkspace()));
                    } catch (IOException e) {
                        e.printStackTrace();

                        logger.info("cannot move fileName from {} to {}",file.getPath()+"/"+file.getFileName(), configuration.getWorkspace());
                        return new ProcessorResult(image, configuration).error("cannot move fileName from "+file.getPath()+"/"+file.getFileName()+ "to "+configuration.getWorkspace());
                    }
                }
            }
        }
        return new ProcessorResult(image, configuration).success();
    }

}
