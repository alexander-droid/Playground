package com.nikolaenko.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nikolaenko.playground.auth.ui.AuthGraph
import com.nikolaenko.playground.core.ui.PlaygroundTheme
import com.nikolaenko.playground.ui.main.Main
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var splash: SplashScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        splash = installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MainViewModelImpl>()

            val state by viewModel.state.collectAsState()
            PlaygroundTheme {
                ApplyBarColors()
                splash.setKeepOnScreenCondition { state.isLoggedIn == null }
                val isLoggedIn = state.isLoggedIn ?: return@PlaygroundTheme
                val startDestination = if (isLoggedIn) {
                    Screen.Main
                } else {
                    Screen.Auth
                }
                val navController = rememberNavController()
                Surface {
                    NavHost(navController = navController, startDestination = startDestination.route) {
                        AuthGraph(
                            navController = navController,
                            route = Screen.Auth.route,
                            onLoggedIn = {
                                navController.navigate(Screen.Main.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                        composable(route = Screen.Main.route) {
                            val isSystemInDarkTheme = isSystemInDarkTheme()
                            Main(
                                onThemeChanged = {
                                    viewModel.toggleDarkMode(isSystemInDarkTheme)
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ApplyBarColors() {
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
        systemUiController.setNavigationBarColor(
            color = Color.Transparent,
            navigationBarContrastEnforced = false
        )
    }
}

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Main : Screen("main")
}
