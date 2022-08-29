package com.nikolaenko.playground.ui.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.feed.ui.Feed
import com.nikolaenko.playground.R
import com.nikolaenko.profile.ui.Profile
import com.nikolaenko.settings.ui.Settings
import com.nikolaenko.utils.logger.Logger

fun NavGraphBuilder.TabsGraph(navController: NavHostController) {
    navigation(startDestination = TabScreen.Feed.route, "tabs") {
        Logger.d("navigation Tabs")
        composable(TabScreen.Feed.route) {
            Logger.d("composable Feed")
            Feed()
        }
        composable(TabScreen.Profile.route) {
            Logger.d("composable Profile")
            Profile()
        }
        composable(TabScreen.Settings.route) {
            Logger.d("composable Settings")
            Settings()
        }
    }
}

sealed class TabScreen(val route: String, val image: ImageVector, @StringRes val titleId: Int) {
    object Feed : TabScreen("feed", Icons.Filled.List, R.string.bottom_tab_feed)
    object Profile : TabScreen("profile", Icons.Filled.Person, R.string.bottom_tab_profile)
    object Settings : TabScreen("settings", Icons.Filled.Settings, R.string.bottom_tab_settings)
}