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
import com.nikolaenko.playground.chat.ui.ChatGraph
import com.nikolaenko.playground.feed.ui.FeedGraph
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
                    scope.launch { drawerState.close() }
                    navController.navigate(Screen.Profile.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                goToChat = {
                    scope.launch { drawerState.close() }
                    navController.navigate(Screen.Chat.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                goToFeed = {
                    scope.launch { drawerState.close() }
                    navController.navigate(Screen.Feed.route) {
                        popUpTo(navController.graph.startDestinationId)
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
                ChatGraph(navController = navController, route = Screen.Chat.route)
                FeedGraph(navController = navController, route = Screen.Feed.route)
            }
        }
    )
}

sealed class Screen(val route: String) {
    object Tabs : Screen("tabs")
    object Profile : Screen("profile_graph")
    object Chat : Screen("chat_graph")
    object Feed : Screen("feed_graph")
}