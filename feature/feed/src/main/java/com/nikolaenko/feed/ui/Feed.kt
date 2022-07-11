package com.nikolaenko.feed.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.insets.statusBarsPadding
import timber.log.Timber

@Composable
fun Feed(navHostController: TestNav, block: () -> Unit) {
    Timber.tag("efegreg").d("Feed")
    Surface(
        modifier = Modifier.statusBarsPadding().fillMaxSize()
    ) {
        Timber.tag("efegreg").d("Feed Text")
        Text(
            text = "Feed!"
        )
    }
}
class TestNav(nav: NavHostController)