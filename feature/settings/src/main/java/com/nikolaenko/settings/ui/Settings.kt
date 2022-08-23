package com.nikolaenko.settings.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun Settings(navHostController: NavHostController) {
    Surface(
        modifier = Modifier.statusBarsPadding().fillMaxSize()
    ) {
        Text(
            text = "Settings!"
        )
    }
}
