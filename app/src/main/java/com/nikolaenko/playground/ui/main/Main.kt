package com.nikolaenko.playground.ui.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolaenko.playground.profile.ui.ProfileGraph
import kotlinx.coroutines.launch

@Composable
fun Main() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        ModalDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(
                    onThemeChanged = {

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
}

sealed class Screen(val route: String) {
    object Tabs : Screen("tabs")
    object Profile : Screen("profile_graph")
}