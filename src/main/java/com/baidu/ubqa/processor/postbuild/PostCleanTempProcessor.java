package com.baidu.ubqa.processor.postbuild;


import com.baidu.ubqa.config.RuntimeConfiguration;
import com.baidu.ubqa.entity.Image;
import com.baidu.ubqa.entity.ProcessorResult;
import java.io.File;
import java.io.IOException;

import com.baidu.ubqa.processor.Processor;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostCleanTempProcessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(PostCleanTempProcessor.class);

    @Override
    public ProcessorResult proceess(Image image, RuntimeConfiguration configuration) {

        try {
            FileUtils.cleanDirectory(new File(configuration.getWorkspace()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ProcessorResult(image, configuration).success();
    }
}