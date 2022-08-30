package com.nikolaenko.playground.profile.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.playground.profile.ui.profile.Profile
import com.nikolaenko.playground.profile.ui.settings.Settings

fun NavGraphBuilder.ProfileGraph(
    navController: NavHostController,
    route: String
) {
    navigation(startDestination = Screen.Profile.route, route = route) {
        composable(Screen.Profile.route) {
            Profile()
        }
        composable(Screen.Settings.route) {
            Settings()
        }
    }
}

internal sealed class Screen(val route: String) {
    object Profile : Screen("profile")
    object Settings : Screen("settings")
}