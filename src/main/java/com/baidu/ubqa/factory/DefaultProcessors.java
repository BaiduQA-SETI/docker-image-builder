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

package com.baidu.ubqa.factory;

import com.baidu.ubqa.processor.build.CacheImageProcessor;
import com.baidu.ubqa.processor.build.ImageBuildProcessor;
import com.baidu.ubqa.processor.build.ImagePushProcessor;
import com.baidu.ubqa.processor.build.ParentImageProcessor;
import com.baidu.ubqa.processor.postbuild.PostCleanBaseImageProcessor;
import com.baidu.ubqa.processor.postbuild.PostCleanCacheProcessor;
import com.baidu.ubqa.processor.postbuild.PostCleanImageProcessor;
import com.baidu.ubqa.processor.prebuild.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultProcessors {
    public List<Class> getProcessors(){
        List<Class> processors = new ArrayList<>();
        processors.add(ValidateProcessor.class);
        processors.add(FormatFilePathProcessor.class);
        processors.add(FileCopyProcessor.class);
        processors.add(EntrypointProcessor.class);
        processors.add(DockerFileProcessor.class);
        processors.add(ParentImageProcessor.class);
        processors.add(CacheImageProcessor.class);
        processors.add(ImageBuildProcessor.class);
        processors.add(ImagePushProcessor.class);
        processors.add(PostCleanCacheProcessor.class);
        processors.add(PostCleanBaseImageProcessor.class);
        processors.add(PostCleanImageProcessor.class);
        // processors.add(PostCleanTempProcessor.class);
        return processors;
    }
}
