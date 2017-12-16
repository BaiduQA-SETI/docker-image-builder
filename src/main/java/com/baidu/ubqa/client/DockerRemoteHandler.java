package com.baidu.ubqa.client;

import com.baidu.ubqa.entity.DockerHost;
import com.baidu.ubqa.entity.ReadOnlyImage;
import com.baidu.ubqa.entity.Registry;
import com.baidu.ubqa.entity.Result;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.exceptions.ImagePushFailedException;
import com.spotify.docker.client.messages.AuthConfig;
import com.spotify.docker.client.messages.RemovedImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by zhaoming03 on 2017/12/5.
 */
public class DockerRemoteHandler {
    private Logger logger = LoggerFactory.getLogger(DockerRemoteHandler.class);

    public Result build(final DockerClient dockerClient, String pathUri, ReadOnlyImage readOnlyImage) {
        String repository = readOnlyImage.getRepository();

        String imageId;
        String errMsg = "build image failed.";
        try {
            imageId = dockerClient.build(Paths.get(pathUri), repository);
            return imageId == null ? new Result().fail(errMsg) : new Result().success(imageId);
        } catch (DockerException e) {
            errMsg = e.getMessage();
            logger.error("build image exception.", e);
        } catch (InterruptedException e) {
            errMsg = e.getMessage();
            logger.error("build image exception.", e);
        } catch (IOException e) {
            errMsg = e.getMessage();
            logger.error("build image exception.", e);
        } catch (Exception e) {
            errMsg = e.getMessage();
            logger.error("build image exception.", e);
        }
        return new Result().fail(errMsg);
    }

    public Result push(final DockerClient dockerClient, ReadOnlyImage readOnlyImage) {
        String repository = readOnlyImage.getRepository();
        String errMsg;
        try {
            dockerClient.push(repository);
            return new Result().success();
        } catch (DockerException e) {
            errMsg = e.getMessage();
            logger.error("push image exception.", e);
        } catch (InterruptedException e) {
            errMsg = e.getMessage();
            logger.error("push image exception.", e);
        } catch (Exception e) {
            errMsg = e.getMessage();
            logger.error("push image exception.", e);
        }
        return new Result().fail(errMsg);
    }

    public Result push(DockerClient dockerClient, ReadOnlyImage readOnlyImage, int maxTryTimes) {
        String repository = readOnlyImage.getRepository();
        String errMsg;
        if (maxTryTimes < 1) {
            maxTryTimes = 1;
        } else if (maxTryTimes > 3) {
            maxTryTimes = 3;
        }

        do {
            try {
                dockerClient.push(repository);
                return new Result().success();
            } catch (ImagePushFailedException e) {
                errMsg = e.getMessage();
                logger.error("push image exception.", e);
            } catch (Exception e) {
                errMsg = e.getMessage();
                logger.error("push image exception.", e);
            }
            maxTryTimes--;
        } while (maxTryTimes > 0);
        return new Result().fail(errMsg);
    }


    public Result pull(final DockerClient dockerClient, ReadOnlyImage readOnlyImage) {
        String repository = readOnlyImage.getRepository();
        String errMsg;
        try {
            dockerClient.pull(repository);
            return new Result().success();
        } catch (DockerException e) {
            errMsg = e.getMessage();
            logger.error("pull image exception.", e);
        } catch (InterruptedException e) {
            errMsg = e.getMessage();
            logger.error("pull image exception.", e);
        } catch (Exception e) {
            errMsg = e.getMessage();
            logger.error("pull image exception.", e);
        }
        return new Result().fail(errMsg);
    }

    public Result remove(final DockerClient dockerClient, ReadOnlyImage readOnlyImage) {
        String repository = readOnlyImage.getRepository();
        String errMsg;
        try {
            List<RemovedImage> removedImageList = dockerClient.removeImage(repository);
            for (RemovedImage image : removedImageList) {
                logger.info("successfully removed image {}", image.imageId());
            }
            return new Result().success();
        } catch (DockerException e) {
            errMsg = e.getMessage();
            logger.error("remove image exception.", e);
        } catch (InterruptedException e) {
            errMsg = e.getMessage();
            logger.error("remove image exception.", e);
        } catch (Exception e) {
            errMsg = e.getMessage();
            logger.error("remove image exception.", e);
        }
        return new Result().fail(errMsg);
    }

    public Result tag(final DockerClient dockerClient, String repository, String name) {
        String errMsg;
        try {
            dockerClient.tag(repository, name, true);
            return new Result().success();
        } catch (DockerException e) {
            errMsg = e.getMessage();
            logger.error("remove image exception.", e);
        } catch (InterruptedException e) {
            errMsg = e.getMessage();
            logger.error("remove image exception.", e);
        } catch (Exception e) {
            errMsg = e.getMessage();
            logger.error("remove image exception.", e);
        }
        return new Result().fail(errMsg);
    }

    public DockerClient buildDockerClient(Registry registry, DockerHost dockerHost) {
        return buildDockerClient(registry, dockerHost, 5000, 900000);
    }

    public DockerClient buildDockerClient(Registry registry, DockerHost dockerHost, long connectTimeout, long readTimeout) {
        String dockerHostUri = new StringBuilder("http://")
                .append(dockerHost.getIp())
                .append(":")
                .append(dockerHost.getPort())
                .toString();
        return buildDockerClient(registry, dockerHostUri, connectTimeout, readTimeout);
    }


    public DockerClient buildDockerClient(Registry registry, String dockerHostUri) {
        return buildDockerClient(registry, dockerHostUri, 5000, 9000);
    }


    public DockerClient buildDockerClient(Registry registry, String dockerHostUri, long connectTimeout, long readTimeout) {

        final DockerClient dockerClient = DefaultDockerClient.builder()
                .authConfig(registry.toAuthConfig())
                .uri(dockerHostUri)
                .connectTimeoutMillis(connectTimeout)
                .readTimeoutMillis(readTimeout)
                .build();
        return dockerClient;
    }
}
