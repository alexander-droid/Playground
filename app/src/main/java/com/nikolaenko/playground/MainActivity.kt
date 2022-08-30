package com.nikolaenko.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
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

            val state = viewModel.state.collectAsState()
            Logger.d("state ${state.value}")
            ProvideWindowInsets {
                val isDarkTheme = state.value.isDarkTheme ?: return@ProvideWindowInsets
                PlaygroundTheme(darkTheme = isDarkTheme) {

                    val systemUiController = rememberSystemUiController()
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = MaterialTheme.colors.isLight
                    )
                    systemUiController.setNavigationBarColor(
                        color = Color.Transparent,
                        darkIcons = MaterialTheme.colors.isLight,
                        navigationBarContrastEnforced = false
                    )

                    val isLoggedIn = state.value.isLoggedIn ?: return@PlaygroundTheme
                    val navController = rememberNavController()
                    val startDestination = if (isLoggedIn) {
                        Screen.Main
                    } else {
                        Screen.Auth
                    }
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
                            Main()
                        }
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Main : Screen("main")
}
