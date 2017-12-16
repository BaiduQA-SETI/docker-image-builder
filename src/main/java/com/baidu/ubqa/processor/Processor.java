package com.baidu.ubqa.processor;

import com.baidu.ubqa.config.RuntimeConfiguration;
import com.baidu.ubqa.entity.Image;
import com.baidu.ubqa.entity.ProcessorResult;
import com.baidu.ubqa.entity.Result;

public interface Processor {

    ProcessorResult proceess(Image image, RuntimeConfiguration configuration);
}
