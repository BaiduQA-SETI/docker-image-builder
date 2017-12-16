package com.baidu.ubqa.dockercommand;

/**
 * Created by zhaoming03 on 2017/12/5.
 */
public enum DockerCommand {
    USER("USER "),
    RUN("RUN "),
    FROM("FROM "),
    MAINTAINER("MAINTAINER "),
    ENV("ENV "),
    ADD("ADD "),
    COPY("COPY "),
    ENTRYPOINT("ENTRYPOINT "),
    EXPOSE("EXPOSE ");


    private final String value;

    DockerCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
