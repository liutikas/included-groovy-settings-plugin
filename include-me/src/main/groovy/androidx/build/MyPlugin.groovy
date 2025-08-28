package androidx.build

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

abstract class MyPlugin implements Plugin<Settings> {
    @Override
    void apply(Settings settings) {

    }
}
