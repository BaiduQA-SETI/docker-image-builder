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
