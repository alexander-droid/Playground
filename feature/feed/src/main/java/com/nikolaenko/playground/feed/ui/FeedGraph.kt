package com.nikolaenko.playground.feed.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.playground.feed.ui.details.PostDetailsScreen
import com.nikolaenko.playground.feed.ui.feed.FeedScreen

@Suppress("FunctionName")
fun NavGraphBuilder.FeedGraph(
    navController: NavHostController,
    route: String
) {
    navigation(startDestination = Screen.Feed.route, route = route) {
        composable(Screen.Feed.route) {
            FeedScreen(
                goToDetails = {
                    navController.navigate(Screen.PostDetails.route)
                }
            )
        }
        composable(Screen.PostDetails.route) {
            PostDetailsScreen()
        }
    }
}

internal sealed class Screen(val route: String) {
    object Feed : Screen("feed")
    object PostDetails : Screen("post_details")
}