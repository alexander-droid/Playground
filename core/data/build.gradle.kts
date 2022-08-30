import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.protobuf") version Libs.Protobuf.pluginVersion
}

android {
    namespace = "com.nikolaenko.playground.core.data"
    compileSdk = Libs.compileSdkVersion

    defaultConfig {
        minSdk = Libs.minSdkVersion
        targetSdk = Libs.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    api(project(":core:domain"))

    implementation(Libs.Androidx.DataStore.dataStore)
    implementation(Libs.Protobuf.javalite)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${Libs.Protobuf.version}"
    }

    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                this.create("java") {
                    this.option("lite")
                }
            }
        }
    }
}