plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
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
    implementation(project(":feature:settings"))
    implementation(project(":core"))
    implementation(project(":coreUi"))

    implementation(Libs.Androidx.coreKtx)
    implementation(Libs.Androidx.Navigation.navigationCompose)

    implementation(Libs.Androidx.Compose.ui)
    implementation(Libs.Androidx.Compose.material)
    implementation(Libs.Androidx.Compose.uiToolingPreview)
    implementation(Libs.Androidx.Compose.materialIconsExtended)
    implementation(Libs.Androidx.Compose.activityCompose)

    implementation(Libs.Hilt.android)
    implementation(Libs.Hilt.navigationCompose)
    kapt(Libs.Hilt.androidCompiler)

    implementation(Libs.Accompanist.insets)
    implementation(Libs.Accompanist.navigationAnimation)
    implementation(Libs.Accompanist.systemUiController)

    implementation(Libs.Timber.timber)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.1.1")
}