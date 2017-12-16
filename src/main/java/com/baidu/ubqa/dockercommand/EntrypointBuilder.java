package com.baidu.ubqa.dockercommand;

import com.baidu.ubqa.utils.Constants;
import com.baidu.ubqa.entity.Script;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EntrypointBuilder {

    private Logger logger = LoggerFactory.getLogger(EntrypointBuilder.class);

    public String makeEntrypoint(List<Script> scripts) {
        StringBuilder entrypoint = new StringBuilder();
        entrypoint.append("#! /bin/bash").append(Constants.FILE_LINE_BREAKER);
        for(Script script : scripts) {
            String block = script.getCommand().replaceAll(Constants.MERGER_SUPPORTED_BLOCK_LINE_SPLITER,Constants.FILE_LINE_BREAKER);
            entrypoint.append(block).append(Constants.FILE_LINE_BREAKER);
        }
        logger.info("entrypoint.sh:{}",entrypoint.toString());
        return entrypoint.toString();
    }


}
