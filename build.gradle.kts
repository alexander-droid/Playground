buildscript {

    dependencies {
        classpath(Libs.Hilt.plugin)
    }
}

plugins {
    id("com.android.application") version Libs.Gradle.version apply false
    id("com.android.library") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("org.jetbrains.kotlin.jvm") version Libs.Kotlin.version apply false
}
