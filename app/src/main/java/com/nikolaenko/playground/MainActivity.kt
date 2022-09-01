package com.nikolaenko.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nikolaenko.playground.auth.ui.AuthGraph
import com.nikolaenko.playground.core.logger.Logger
import com.nikolaenko.playground.core.ui.PlaygroundTheme
import com.nikolaenko.playground.ui.main.Main
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = getViewModel<MainViewModel>()

            val state by viewModel.state.collectAsState()
            Logger.d("state $state")
            ProvideWindowInsets {
                PlaygroundTheme(darkTheme = state.isDarkTheme ?: isSystemInDarkTheme()) {
                    setBarColors()
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
                                Main(viewModel)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun setBarColors() {
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = PlaygroundTheme.colors.isLight
        )
        systemUiController.setNavigationBarColor(
            color = Color.Transparent,
            darkIcons = PlaygroundTheme.colors.isLight,
            navigationBarContrastEnforced = false
        )
    }
}

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Main : Screen("main")
}
