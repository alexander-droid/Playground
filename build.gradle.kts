buildscript {

    dependencies {

    }
}

plugins {
    id("com.android.application") version Libs.Gradle.version apply false
    id("com.android.library") version Libs.Gradle.version apply false
    id("org.jetbrains.kotlin.android") version Libs.Kotlin.version apply false
    id("org.jetbrains.kotlin.jvm") version Libs.Kotlin.version apply false
    id("com.google.dagger.hilt.android") version Libs.Hilt.version apply false
}
