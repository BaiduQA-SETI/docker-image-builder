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
