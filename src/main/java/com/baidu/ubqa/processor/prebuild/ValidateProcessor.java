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
