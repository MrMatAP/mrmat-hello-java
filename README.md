# MrMat :: Hello Java

Java Experiments

[![Build](https://github.com/MrMatAP/mrmat-hello-java/actions/workflows/build.yml/badge.svg)](https://github.com/MrMatAP/mrmat-hello-java/actions/workflows/build.yml)
[![SAST](https://github.com/MrMatAP/mrmat-hello-java/actions/workflows/codeql.yml/badge.svg)](https://github.com/MrMatAP/mrmat-hello-java/actions/workflows/codeql.yml)

## How to use this

This repository serves as a demonstration on how to get a Java project on its feet. There is currently nothing truly
functional demonstrated except for a reasonable CI process as well as tests for a number of Java features.

## How to build this

Just run `./gradlew build`.

An interactive build will always default to '0.0.0-SNAPSHOT' for its version. We use this as a simple marker that
the project has not been built by a CI mechanism. It is possible to override this behaviour by setting the 
'MRMAT_VERSION' environment variable to whatever version is desired but doing 
so in a local interactive build is discouraged.

### As part of a CI build

GitHub Actions will trigger a build upon a push and as part of a pull request. If the build is the result of a merge 
onto the merge branch then it is considered to be a release build which will cause a tag to be created. The version is 
suffixed with '-SNAPSHOT' for any non-release build.

The build version is relayed via the 'MRMAT_VERSION' environment variable from the 'MAJOR', 'MINOR' operational 
variables as well as the 'GITHUB_RUN_NUMBER'. 'MAJOR' and 'MINOR' are meant to be adjusted manually because those are 
conscious version bumps that are expected to happen far less frequently than individual builds. The 'GITHUB_RUN_NUMBER' 
is injected by GitHub Actions itself, resulting in a discrete version of the product for each build.

### SAST

SAST is provided by CodeQL straight in the main `.github/workflows/codeql.yml` workflow.

