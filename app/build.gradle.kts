plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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
    implementation(project(":feature:feed"))
    implementation(project(":feature:profile"))
    implementation(project(":feature:chat"))
    implementation(project(":feature:auth"))
    implementation(project(":core"))

    implementation(Libs.Androidx.coreKtx)
    implementation(Libs.Androidx.Navigation.navigationCompose)
    implementation(Libs.Androidx.material)

    implementation(Libs.Androidx.Compose.ui)
    implementation(Libs.Androidx.Compose.material)
    implementation(Libs.Androidx.Compose.uiToolingPreview)
    implementation(Libs.Androidx.Compose.materialIconsExtended)
    implementation(Libs.Androidx.Compose.activityCompose)
    implementation(Libs.Androidx.Compose.constraintLayout)

    implementation(Libs.Koin.android)
    implementation(Libs.Koin.compose)

    implementation(Libs.Accompanist.insets)
    implementation(Libs.Accompanist.navigationAnimation)
    implementation(Libs.Accompanist.systemUiController)
}