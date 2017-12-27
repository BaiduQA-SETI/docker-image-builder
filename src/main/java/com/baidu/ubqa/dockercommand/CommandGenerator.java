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

package com.baidu.ubqa.dockercommand;

import com.baidu.ubqa.utils.Constants;
import com.baidu.ubqa.entity.EnvironmentVariable;
import com.baidu.ubqa.entity.Port;
import com.baidu.ubqa.entity.Script;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhaoming03 on 2017/12/5.
 */
public class CommandGenerator {
    private Logger logger = LoggerFactory.getLogger(CommandGenerator.class);


    public String generateCommonBlock(DockerCommand command, String line){
        StringBuilder commandBlock = new StringBuilder();
        commandBlock.append(command.getValue());
        commandBlock.append(line);
        commandBlock.append(Constants.FILE_LINE_BREAKER);
        String block = commandBlock.toString();
        logger.info("block generated: {}",block);
        return block;
    }

    public String generateExposeBlock(List<Port> ports){
        if(ports == null || ports.isEmpty()) {
            return "";
        }
        List<String> portNumbers = ports.stream()
                .map(port -> (DockerCommand.EXPOSE.getValue() + port.getPort()))
                .collect(Collectors.toList());
        String block = String.join(Constants.FILE_LINE_BREAKER, portNumbers);
        logger.info("block generated: {}",block);
        return block + Constants.FILE_LINE_BREAKER;
    }

    public String generateEnvBlock(List<EnvironmentVariable> envs){
        if(envs == null || envs.isEmpty()) {
            logger.info("block generated: {}","");
            return "";
        }
        List<String> envStrings = envs.stream()
                .map(env->(DockerCommand.ENV.getValue() + env.getName() + Constants.ENV_PARA_SPLITER + env.getValue()))
                .collect(Collectors.toList());
        String block = String.join(Constants.FILE_LINE_BREAKER, envStrings);
        logger.info("block generated: {}",block);
        return block + Constants.FILE_LINE_BREAKER;
    }

    public String generateAddLine(String source, String destination) {
        destination = destination.endsWith(Constants.FILE_PATH_SPLITER) ? destination : destination.concat(Constants.FILE_PATH_SPLITER);
        StringBuilder commandLine = new StringBuilder();
        commandLine.append(DockerCommand.ADD.getValue())
                .append(source)
                .append(Constants.COMMAND_PARA_SPLITER)
                .append(destination)
                .append(Constants.FILE_LINE_BREAKER);
        String block = commandLine.toString();
        logger.info("block generated: {}",block);
        return block;
    }

    public String generateCopyLine(String source, String destination) {
        destination = destination.endsWith(Constants.FILE_PATH_SPLITER) ? destination : destination.concat(Constants.FILE_PATH_SPLITER);
        StringBuilder commandBlock = new StringBuilder();
        commandBlock.append(DockerCommand.COPY.getValue())
                .append(source)
                .append(Constants.COMMAND_PARA_SPLITER)
                .append(destination)
                .append(Constants.FILE_LINE_BREAKER);
        String block = commandBlock.toString();
        logger.info("block generated: {}",block);
        return block;
    }

    public String generateRunLine(String commandLine) {
        StringBuilder block = new StringBuilder();
        block.append(DockerCommand.RUN.getValue())
                .append(commandLine)
                .append(Constants.FILE_LINE_BREAKER);
        logger.info("block generated: {}",block);
        return block.toString();
    }

    public String generateRunLine(List<Script> scripts) {
        if(scripts == null || scripts.isEmpty()){
            logger.info("block generated: {}","");
            return "";
        }
        StringBuilder runBlock = new StringBuilder();
        for(Script script : scripts){
            String blockCommand = script.getCommand();
            blockCommand.replaceAll(Constants.MERGER_SUPPORTED_BLOCK_LINE_SPLITER, Constants.FILE_LINE_BREAKER);
            String commandLine = String.join(Constants.DOCKER_COMMAND_BLOCK_LINE_JOINER,blockCommand.split(Constants.FILE_LINE_BREAKER));
            runBlock.append(DockerCommand.RUN.getValue())
                    .append(commandLine)
                    .append(Constants.FILE_LINE_BREAKER);
        }
        String block = runBlock.toString();
        logger.info("block generated: {}",block);
        return block;
    }


}
