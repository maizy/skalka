# Skalka

Collection of cli tools writen specially for GraalVM AOT Compiler.

[![Build Status](https://travis-ci.org/maizy/skalka.svg?branch=master)](https://travis-ci.org/maizy/skalka)

_Work in progress_

## Tools


### Tests, compatibility checks

| name | status | description |
| ---- | ------ | ----------- |
| hello-world-test | ✅ | testing scala |
| aws-test | ❌ (tsl support required) | testing aws sdk support |
| jline-test | ✅ | testing jline support (rich terminal with autocomplete) |

## Build

1\. Add native-image to your PATH
```
export "PATH=/path/to/graalvm-ee/Contents/Home/bin:$PATH
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
