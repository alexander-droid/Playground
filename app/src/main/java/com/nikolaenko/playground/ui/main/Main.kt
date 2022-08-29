package com.nikolaenko.playground.ui.main

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.utils.logger.Logger

fun NavGraphBuilder.MainGraph(
    navController: NavHostController
) {
    navigation(startDestination = Screen.Tabs.route, "main") {
        Logger.d("navigation Main")
        composable(Screen.Tabs.route) {
            Tabs(navController)
        }
        composable(Screen.Profile.route) {
//            Profile()
        }
        composable(Screen.Settings.route) {
//            Settings()
        }
    }
}

@Composable
fun NavGraphBuilder.Tabs(navController: NavHostController) {
    val screens = listOf(TabScreen.Feed, TabScreen.Profile, TabScreen.Settings)
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            bottomBar = { BottomBar(navController, screens) },
            drawerContent = { /*DrawerContent(viewModel::toggleDarkMode)*/ }
        ) { innerPadding ->
            TabsGraph(navController)
        }
    }
}

sealed class Screen(val route: String) {
    object Tabs : Screen("tabs")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
}