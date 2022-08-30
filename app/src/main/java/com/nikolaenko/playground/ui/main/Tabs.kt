package com.nikolaenko.playground.ui.main

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.playground.R
import com.nikolaenko.playground.feed.ui.FeedGraph
import com.nikolaenko.playground.profile.ui.Profile

@Composable
fun NavGraphBuilder.Tabs(
    navController: NavHostController,
    route: String
) {
    val screens = listOf(TabScreen.Feed, TabScreen.Chtat)
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            bottomBar = { BottomBar(navController, screens) },
            drawerContent = { /*DrawerContent(viewModel::toggleDarkMode)*/ }
        ) { innerPadding ->
            TabsGraph(navController = navController, route = route)
        }
    }
}

fun NavGraphBuilder.TabsGraph(
    navController: NavHostController,
    route: String
) {
    navigation(startDestination = TabScreen.Feed.route, route) {
        FeedGraph(navController, TabScreen.Feed.route)
        composable(TabScreen.Chtat.route) {
            Profile()
        }
    }
}

sealed class TabScreen(val route: String, val image: ImageVector, @StringRes val titleId: Int) {
    object Feed : TabScreen("feed", Icons.Filled.List, R.string.bottom_tab_feed)
    object Chtat : TabScreen("chat", Icons.Filled.Chat, R.string.bottom_tab_chat)
}