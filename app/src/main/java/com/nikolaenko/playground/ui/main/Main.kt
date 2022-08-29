package com.nikolaenko.playground.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolaenko.feed.ui.Feed
import com.nikolaenko.playground.MainViewModel
import com.nikolaenko.playground.navigation.Screen
import com.nikolaenko.profile.ui.Profile
import com.nikolaenko.settings.ui.Settings
import com.nikolaenko.utils.logger.Logger
import org.koin.androidx.compose.getViewModel

@Composable
fun Main() {
    val viewModel = getViewModel<MainViewModel>()
    val navController = rememberNavController()
    val screens = listOf(Screen.Feed, Screen.Profile, Screen.Settings)

    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            bottomBar = { BottomBar(navController, screens) },
            drawerContent = { DrawerContent(viewModel::toggleDarkMode) }
        ) { innerPadding ->
            NavHost(navController, startDestination = Screen.Feed.route, Modifier.padding(innerPadding)) {
                Logger.d("NavHost")
                composable(Screen.Feed.route) {
                    Logger.d("composable Feed")
                    Feed(navController)
                }
                composable(Screen.Profile.route) {
                    Logger.d("composable Profile")
                    Profile()
                }
                composable(Screen.Settings.route) {
                    Logger.d("composable Settings")
                    Settings()
                }
            }
        }
    }
}