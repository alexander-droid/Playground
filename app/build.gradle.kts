plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.nikolaenko.playground"
    compileSdk = Libs.compileSdkVersion

    defaultConfig {
        applicationId = "com.nikolaenko.playground"
        minSdk = Libs.minSdkVersion
        targetSdk = Libs.targetSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Androidx.Compose.version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":feature:feed"))
    implementation(project(":feature:profile"))
    implementation(project(":feature:chat"))
    implementation(project(":feature:auth"))
    implementation(project(":feature:questionnaire"))

    implementation(Libs.Androidx.coreKtx)
    implementation(Libs.Androidx.Navigation.navigationCompose)
    implementation(Libs.Androidx.material)
    implementation(Libs.Androidx.splash)

    implementation(Libs.Androidx.Compose.ui)
    implementation(Libs.Androidx.Compose.material3)
    debugImplementation(Libs.Androidx.Compose.uiTooling)
    implementation(Libs.Androidx.Compose.materialIconsExtended)
    implementation(Libs.Androidx.Compose.activityCompose)
    implementation(Libs.Androidx.Compose.constraintLayout)

    implementation(Libs.Hilt.android)
    implementation(Libs.Hilt.navigationCompose)
    kapt(Libs.Hilt.androidCompiler)
    kapt(Libs.Hilt.androidExtCompiler)

    implementation(Libs.Accompanist.navigationAnimation)
    implementation(Libs.Accompanist.systemUiController)
}