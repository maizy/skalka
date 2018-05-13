# Skalka

Collection of cli tools writen specially for GraalVM AOT Compiler.

_Work in progress_

## Tools


### Tests, compatibility checks

| name | status | description |
| ---- | ------ | ----------- |
| hello-world-test | ✅ | testing scala |
| aws-test | ❌ (tsl support required) | testing aws sdk support |

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

one tool only:

```
./gradlew :tool-name:buildNative
```

3\. Tool will be in `tool-name/build/native/tool-name`.

## License

Apache License 2.0
