object Libs {

    const val minSdkVersion = 26
    const val targetSdkVersion = 33
    const val compileSdkVersion = 33

    object Gradle {
        const val version = "8.0.0"
    }

    object Kotlin {
        const val version = "1.8.10"
    }

    object Accompanist {
        const val version = "0.28.0"
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

    object Coil {
        const val version = "2.2.2"
        const val coil = "io.coil-kt:coil-compose:$version"
    }

    object Retrofit {
        const val version = "2.9.0"

        const val refrofit = "com.squareup.retrofit2:retrofit:$version"
        const val moshi = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object Moshi {
        const val version = "1.14.0"

        const val moshi = "com.squareup.moshi:moshi:$version"
        const val adapters = "com.squareup.moshi:moshi-adapters:$version"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val kapt = "com.squareup.moshi:moshi-kotlin-codegen:1.13.0:$version"
    }

    object Androidx {
        const val material = "com.google.android.material:material:1.8.0"
        const val coreKtx = "androidx.core:core-ktx:1.10.0"
        const val splash = "androidx.core:core-splashscreen:1.0.0"

        object Compose {
            const val version = "1.4.4"

            const val ui = "androidx.compose.ui:ui:1.4.1"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:1.4.1"
            const val uiTooling = "androidx.compose.ui:ui-tooling:1.4.1"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:1.4.1"
            const val activityCompose = "androidx.activity:activity-compose:1.7.0"
            const val material3 = "androidx.compose.material3:material3:1.0.1"
            const val material = "androidx.compose.material:material:1.4.1"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
            const val paging = "androidx.paging:paging-compose:1.0.0-alpha18"
        }

        object Navigation {
            const val navigationCompose = "androidx.navigation:navigation-compose:2.5.3"
        }

        object DataStore {
            const val dataStore = "androidx.datastore:datastore:1.0.0"
        }
    }

    object Protobuf {
        const val version = "3.19.4"
        const val pluginVersion = "0.9.0"
        const val javalite = "com.google.protobuf:protobuf-javalite:$version"
    }
}
