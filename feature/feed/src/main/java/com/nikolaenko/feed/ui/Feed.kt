package com.nikolaenko.feed.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.insets.statusBarsPadding
import timber.log.Timber

@Composable
fun Feed(navHostController: NavHostController, block: () -> Unit) {
    Timber.tag("efegreg").d("Feed")

    val viewModel = viewModel<FeedViewModelImpl>()

    Surface(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        Timber.tag("efegreg").d("Feed Text")
        Text(
            text = "Feed!"
        )
    }
}
