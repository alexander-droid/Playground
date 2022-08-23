package com.nikolaenko.feed.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.insets.statusBarsPadding
import com.nikolaenko.core.logger.Logger
import org.koin.androidx.compose.getViewModel

@Composable
fun Feed(navHostController: NavHostController, block: () -> Unit) {
    Logger.d("Feed")

    val viewModel = getViewModel<FeedViewModel>()

    Surface(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        Text(
            text = "Feed!"
        )
    }
}
