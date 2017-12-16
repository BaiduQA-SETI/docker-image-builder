package com.baidu.ubqa.factory;

import com.baidu.ubqa.config.RuntimeConfiguration;
import com.baidu.ubqa.entity.Image;
import com.baidu.ubqa.entity.ProcessorResult;
import com.baidu.ubqa.processor.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zhaoming03 on 2017/12/5.
 */
public class ImageFactory {
    private Logger logger = LoggerFactory.getLogger(ImageFactory.class);

    public ProcessorResult produce(Image image, RuntimeConfiguration configuration ) {
        List<Class> processors = new DefaultProcessors().getProcessors();
        return this.produce(processors, image, configuration);
    }

    public ProcessorResult produce(List<Class> processors,Image image, RuntimeConfiguration configuration ) {
    ProcessorResult result = new ProcessorResult(image, configuration);
    result.setStatus(true);
    for(Class processorClass : processors) {
        if(result.getStatus()){
            try {
                Processor processor = (Processor) processorClass.newInstance();
                logger.info("Processor start:" + processorClass.getName());
                result = processor.proceess(image, configuration);
                logger.info("Processor end, result:" + result.toString());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }else{
            break;
        }

    }
    return result;
}
}
