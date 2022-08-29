plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.nikolaenko.feed"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Androidx.Compose.version
    }
}

dependencies {
    implementation(project(":utilsUi"))
    implementation(project(":utils"))
    api(project(":feature:feed:data"))

    implementation(Libs.Androidx.Compose.ui)
    implementation(Libs.Androidx.Compose.material)
    implementation(Libs.Androidx.Compose.uiToolingPreview)

    implementation(Libs.Androidx.Navigation.navigationCompose)

    implementation(Libs.Accompanist.insets)

    implementation(Libs.Koin.android)
    implementation(Libs.Koin.compose)
}
