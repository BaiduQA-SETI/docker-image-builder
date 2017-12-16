# docker-image-builder
Build a docker image from pieces of standard components.

## Dpendency
The image builder is based on [com.spotify.docker-client](https://github.com/spotify/docker-client), which use [Docker Engine API](https://docs.docker.com/engine/api/v1.27/#section/Versioning), to communicate docker host.
So make sure you already have a docker host support Docker HTTP API.
