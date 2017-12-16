package com.baidu.ubqa.processor.prebuild;

import com.baidu.ubqa.config.RuntimeConfiguration;
import com.baidu.ubqa.dockercommand.EntrypointBuilder;
import com.baidu.ubqa.entity.Image;
import com.baidu.ubqa.entity.ProcessorResult;
import com.baidu.ubqa.processor.Processor;
import com.baidu.ubqa.utils.Constants;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class EntrypointProcessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(EntrypointProcessor.class);

    @Override
    public ProcessorResult proceess(Image image, RuntimeConfiguration configuration) {
        EntrypointBuilder entrypointBuilder = new EntrypointBuilder();
        String fileContent = entrypointBuilder.makeEntrypoint(image.getAllRunScripts());
        try {
            FileUtils.write(new File(String.format("%s/entrypoint.sh", configuration.getWorkspace())), fileContent, Constants.DEFAULT_FILE_ENCODING);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("cannot write to {}", String.format("%s/entrypoint.sh", configuration.getWorkspace()));
            return new ProcessorResult(image, configuration).error(String.format("cannot write to fileName %s/entrypoint.sh", configuration.getWorkspace()));
        }
        return new ProcessorResult(image, configuration).success();
    }
}
