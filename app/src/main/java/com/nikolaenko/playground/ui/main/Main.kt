package com.nikolaenko.playground.ui.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.playground.profile.ui.Profile

fun NavGraphBuilder.MainGraph(
    navController: NavHostController
) {
    navigation(startDestination = Screen.Tabs.route, "main") {
        composable(Screen.Tabs.route) {
            Tabs(navController = navController, route = Screen.Tabs.route)
        }
        composable(route = Screen.Profile.route) {
            Profile()
        }
    }
}

sealed class Screen(val route: String) {
    object Tabs : Screen("tabs")
    object Profile : Screen("profile")
}