package com.nikolaenko.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nikolaenko.auth.ui.Auth
import com.nikolaenko.playground.ui.main.Main
import com.nikolaenko.utilsui.theme.PlaygroundTheme
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel = getViewModel<MainViewModel>()

            val state = viewModel.state.collectAsState()
            ProvideWindowInsets {
                val isDarkTheme = state.value.isDarkTheme ?: return@ProvideWindowInsets
                PlaygroundTheme(darkTheme = isDarkTheme) {

                    val systemUiController = rememberSystemUiController()
                    systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = MaterialTheme.colors.isLight)
                    systemUiController.setNavigationBarColor(
                        color = Color.Transparent,
                        darkIcons = MaterialTheme.colors.isLight,
                        navigationBarContrastEnforced = false
                    )

                    val isLoggedIn = state.value.isLoggedIn ?: return@PlaygroundTheme
                    if(isLoggedIn) {
                        Main()
                    } else {
                        Auth()
                    }
                }
            }
        }
    }
}