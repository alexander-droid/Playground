package com.nikolaenko.playground.profile.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.playground.profile.ui.profile.ProfileScreen
import com.nikolaenko.playground.profile.ui.settings.SettingsScreen

@Suppress("FunctionName")
fun NavGraphBuilder.ProfileGraph(
    navController: NavHostController,
    route: String
) {
    navigation(startDestination = Screen.Profile.route, route = route) {
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
        composable(Screen.Settings.route) {
            SettingsScreen()
        }
    }
}

internal sealed class Screen(val route: String) {
    object Profile : Screen("profile")
    object Settings : Screen("settings")
}