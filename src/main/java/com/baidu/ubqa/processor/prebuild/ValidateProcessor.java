package com.baidu.ubqa.processor.prebuild;

import com.baidu.ubqa.config.RuntimeConfiguration;
import com.baidu.ubqa.entity.Image;
import com.baidu.ubqa.entity.ProcessorResult;
import com.baidu.ubqa.processor.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidateProcessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(ValidateProcessor.class);


    @Override
    public ProcessorResult proceess(Image image, RuntimeConfiguration configuration) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Image>> imageViolations = validator.validate(image);
        if(!imageViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for(ConstraintViolation violation : imageViolations) {
                builder.append(violation.getPropertyPath() + " : " + violation.getMessage() + ";");
            }
            return new ProcessorResult(image, configuration).error(builder.toString());
        }
        Set<ConstraintViolation<RuntimeConfiguration>> configurationViolations = validator.validate(configuration);
        if(!configurationViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for(ConstraintViolation violation : configurationViolations) {
                builder.append(violation.getPropertyPath() + " : " + violation.getMessage() + ";");
            }
            return new ProcessorResult(image, configuration).error(builder.toString());
        }
        return new ProcessorResult(image, configuration).success();
    }
}
