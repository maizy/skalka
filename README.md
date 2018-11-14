# Skalka

Collection of cli tools writen specially for GraalVM AOT Compiler.

[![Build Status](https://travis-ci.org/maizy/skalka.svg?branch=master)](https://travis-ci.org/maizy/skalka)

_Work in progress_

## Tools


### Tests, compatibility checks

| name | status (latest graalvm-ce) | description |
| ---- | ------------------- | ----------- |
| hello-world-test | ✅ | testing scala |
| aws-test | ❌ (apache http client support required) | testing aws sdk support |
| ahc-test | ❌ (SSL socket factory failed [graalvm issue #768](https://github.com/oracle/graal/issues/768)) | testing apache http client 4.5.x support (used in various libraries for ex. in aws-sdk) |
| jline-test | ✅ | testing jline support (rich terminal with autocomplete) |

## Build

Minimum supported GraalVM version: 1.0.0-rc9

1\. Add native-image to your PATH
```
export "PATH=/path/to/graalvm-ce-or-ee/Contents/Home/bin:$PATH
```

2\. Build

All tools:

```
./gradlew buildNative
```

Only one tool:

```
./gradlew :tool-name:buildNative
```

3\. Tool will be in `tool-name/build/native/tool-name`.

## License

Apache License 2.0
