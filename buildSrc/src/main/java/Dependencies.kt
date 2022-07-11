object Libs {

    const val minSdkVersion = 26
    const val targetSdkVersion = 33
    const val compileSdkVersion = 33

    object Gradle {
        const val version = "7.4.0-alpha08"
    }

    object Kotlin {
        const val version = "1.6.21"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.1"
    }

    object Accompanist {
        const val version = "0.23.1"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:$version"
        const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:$version"
    }

    object Hilt {
        const val version = "2.38.1"
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
    }

    object Androidx {

        const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        const val coreKtx = "androidx.core:core-ktx:1.8.0"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.0"
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0"

        object Compose {
            const val version = "1.2.0-beta01"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val activityCompose = "androidx.activity:activity-compose:1.5.0"
            const val material = "androidx.compose.material:material:1.3.0-alpha01"
        }

        object Navigation {
            const val version = "2.5.0-alpha03"
            const val navigationCompose = "androidx.navigation:navigation-compose:$version"
        }

        object DataStore {
            const val version = "1.0.0"
            const val dataStore = "androidx.datastore:datastore:$version"
        }
    }

    object Protobuf {
        const val version = "3.19.4"
        const val javalite = "com.google.protobuf:protobuf-javalite:$version"
    }

    object Timber {
        const val version = "5.0.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }
}
