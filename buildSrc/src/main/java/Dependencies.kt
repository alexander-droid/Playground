object Libs {

    const val minSdkVersion = 26
    const val targetSdkVersion = 33
    const val compileSdkVersion = 33

    object Gradle {
        const val version = "7.4.2"
    }

    object Kotlin {
        const val version = "1.7.21"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.4"
    }

    object Accompanist {
        const val version = "0.28.0"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:$version"
        const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:$version"
    }

    object Hilt {
        const val version = "2.44"
        const val android = "com.google.dagger:hilt-android:$version"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val androidExtCompiler = "androidx.hilt:hilt-compiler:1.0.0"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Androidx {

        const val lifecycleVersion = "2.6.0-alpha01"

        const val material = "com.google.android.material:material:1.6.1"
        const val coreKtx = "androidx.core:core-ktx:1.8.0"
        const val splash = "androidx.core:core-splashscreen:1.0.0-beta02"
        // ViewModel
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        // ViewModel utilities for Compose
        const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
        // Lifecycles only (without ViewModel or LiveData)
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
        // Annotation processor - if using Java8, use the following instead of lifecycle-compiler
        const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        // optional - helpers for implementing LifecycleOwner in a Service
        const val lifecycleService = "androidx.lifecycle:lifecycle-service:$lifecycleVersion"
        // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
        const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:$lifecycleVersion"

        object Compose {
            const val version = "1.4.0-alpha02"
            const val materialVersion = "1.1.0-alpha04"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:1.4.0-alpha04"
            const val uiTooling = "androidx.compose.ui:ui-tooling:1.4.0-alpha04"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val activityCompose = "androidx.activity:activity-compose:1.5.0"
            const val material = "androidx.compose.material3:material3:$materialVersion"
            const val materialRipple = "androidx.compose.material:material-ripple:$version"
            const val materialWindowSize = "aandroidx.compose.material3:material3-window-size-class:$materialVersion"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
        }

        object Navigation {
            const val version = "2.6.0-alpha04"
            const val navigationCompose = "androidx.navigation:navigation-compose:$version"
        }

        object DataStore {
            const val version = "1.1.0-alpha01"
            const val dataStore = "androidx.datastore:datastore:$version"
        }
    }

    object Protobuf {
        const val version = "3.19.4"
        const val pluginVersion = "0.8.12"
        const val javalite = "com.google.protobuf:protobuf-javalite:$version"
    }
}
