package com.nikolaenko.playground.feed.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.playground.feed.ui.details.PostDetails
import com.nikolaenko.playground.feed.ui.feed.Feed

fun NavGraphBuilder.FeedGraph(
    navController: NavHostController,
    route: String
) {
    navigation(startDestination = Screen.Feed.route, route = route) {
        composable(Screen.Feed.route) {
            Feed(
                goToDetails = {
                    navController.navigate(Screen.PostDetails.route)
                }
            )
        }
        composable(Screen.PostDetails.route) {
            PostDetails()
        }
    }
}

internal sealed class Screen(val route: String) {
    object Feed : Screen("feed")
    object PostDetails : Screen("post_details")
}