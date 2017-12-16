package com.baidu.ubqa.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileGenerator {
    public boolean generateFile(String basedir, String filename, String fileContent) {
        String targetFilePath = basedir + filename;
        try {
            FileUtils.write(new File(targetFilePath), fileContent, Constants.DEFAULT_FILE_ENCODING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean generateDockerfile(String basedir, String fileContent) {

        return generateFile(basedir, "dockerfile", fileContent);
    }

    public boolean generateEntrypointFile(String basedir, String fileContent) {
        return generateFile(basedir, "entrypoint.sh", fileContent);
    }
}
