plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.protobuf") version Libs.Protobuf.pluginVersion
}

android {
    namespace = "com.nikolaenko.playground.core"
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Androidx.Compose.version
    }
}

dependencies {
    implementation(Libs.Androidx.Compose.ui)
    implementation(Libs.Androidx.Compose.material3)
    implementation(Libs.Androidx.Compose.paging)
    debugImplementation(Libs.Androidx.Compose.uiTooling)

    implementation(Libs.Androidx.DataStore.dataStore)
    implementation(Libs.Protobuf.javalite)

    implementation(Libs.Androidx.Navigation.navigationCompose)

    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.androidCompiler)

    implementation(Libs.Moshi.moshi)
    implementation(Libs.Moshi.kotlin)

    implementation(Libs.Retrofit.refrofit)
    implementation(Libs.Retrofit.moshi)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${Libs.Protobuf.version}"
    }

    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                this.create("java") {
                    this.option("lite")
                }
            }
        }
    }
}