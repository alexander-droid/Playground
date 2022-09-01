package com.nikolaenko.playground.ui.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolaenko.playground.MainViewModel
import com.nikolaenko.playground.profile.ui.ProfileGraph
import kotlinx.coroutines.launch

@Composable
fun Main(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val isSystemInDarkTheme = isSystemInDarkTheme()
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                onThemeChanged = {
                    viewModel.toggleDarkMode(isSystemInDarkTheme)
                },
                goToProfile = {
                    scope.launch {
                        drawerState.close()
                    }
                    navController.navigate(Screen.Profile.route) {
                        launchSingleTop = true
                    }
                }
            )
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = Screen.Tabs.route
            ) {
                composable(route = Screen.Tabs.route) {
                    Tabs()
                }
                ProfileGraph(navController = navController, route = Screen.Profile.route)
            }
        }
    )
}

sealed class Screen(val route: String) {
    object Tabs : Screen("tabs")
    object Profile : Screen("profile_graph")
}