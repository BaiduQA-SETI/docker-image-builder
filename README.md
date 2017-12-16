# docker-image-builder
Build a docker image from pieces of standard components.

## Dpendency
The image builder is based on [com.spotify.docker-client][1], which use [Docker Engine API][2], to communicate docker host.
So make sure you already have a docker host support Docker HTTP API.
  [1]: https://github.com/spotify/docker-client
  [2]: https://docs.docker.com/engine/api/v1.27/#section/Versioning