package com.baidu.ubqa.processor.prebuild;

import com.baidu.ubqa.config.RuntimeConfiguration;
import com.baidu.ubqa.entity.Image;
import com.baidu.ubqa.entity.ProcessorResult;
import com.baidu.ubqa.entity.UploadFile;
import com.baidu.ubqa.processor.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class FormatFilePathProcessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(FormatFilePathProcessor.class);


    @Override
    public ProcessorResult proceess(Image image, RuntimeConfiguration configuration) {
        List<UploadFile> files = image.getAllFiles();
        for(UploadFile file : files){
            if(!file.getPath().endsWith("/")) {
                file.setPath( file.getPath().concat("/"));
            }
        }
        if(!image.getWorkdir().endsWith("/")) {
            image.setWorkdir(image.getWorkdir().concat("/"));
        }
        return new ProcessorResult(image, configuration).success();
    }
}
