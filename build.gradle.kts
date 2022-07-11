buildscript {

    dependencies {
        classpath(Libs.Hilt.plugin)
    }
}

plugins {
    id("com.android.application") version Libs.Gradle.version apply false
    id("com.android.library") version Libs.Gradle.version apply false
    id("org.jetbrains.kotlin.android") version Libs.Kotlin.version apply false
    id("org.jetbrains.kotlin.jvm") version Libs.Kotlin.version apply false
}
