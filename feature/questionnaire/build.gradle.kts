plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.nikolaenko.playground.questionnaire"
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
    implementation(project(":core"))

    implementation(Libs.Androidx.Compose.ui)
    implementation(Libs.Androidx.Compose.material3)
    implementation(Libs.Androidx.Compose.constraintLayout)
    implementation(Libs.Androidx.Compose.materialIconsExtended)
    debugImplementation(Libs.Androidx.Compose.uiTooling)

    implementation(Libs.Hilt.android)
    implementation(Libs.Hilt.navigationCompose)
    implementation(Libs.Accompanist.navigationAnimation)
    kapt(Libs.Hilt.androidCompiler)
}