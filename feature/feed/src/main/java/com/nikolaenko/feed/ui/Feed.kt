package com.nikolaenko.feed.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.nikolaenko.utils.logger.Logger

@Composable
fun Feed(navController: NavHostController) {
    Logger.d("Feed $navController")
}
