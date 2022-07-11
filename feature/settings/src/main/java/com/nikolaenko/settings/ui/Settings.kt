package com.nikolaenko.settings.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.insets.statusBarsPadding
import timber.log.Timber

@Composable
fun Settings(navHostController: NavHostController) {
    Timber.tag("efegreg").d("Settings")
    Surface(
        modifier = Modifier.statusBarsPadding().fillMaxSize()
    ) {
        Timber.tag("efegreg").d("Settings Text")
        Text(
            text = "Settings!"
        )
    }
}
