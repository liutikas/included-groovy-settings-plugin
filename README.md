# Repro of unexpected task invalidations

## Steps

1. `./gradlew :tasks --no-configuration-cache -Dorg.gradle.caching.debug=true -Dorg.gradle.projectcachedir="out/gradle-project-cache"`
2. `./gradlew :tasks --no-configuration-cache -Dorg.gradle.caching.debug=true -Dorg.gradle.projectcachedir="out/gradle-project-cache"`

## Expected

`:include-me:compileGroovy` is up to date on the second run

## Actual

` :include-me:compileGroovy` is not up to date and it runs again due to:

```text
Non-cacheable because Gradle does not know how file 'build/classes/groovy/main' was created (output property 'destinationDirectory'). Task output caching requires exclusive access to output paths to guarantee correctness (i.e. multiple tasks are not allowed to produce output in the same location). [OVERLAPPING_OUTPUTS]
```
