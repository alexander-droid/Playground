package com.nikolaenko.playground.ui.feed

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun Feed(navHostController: NavHostController) {
    Surface(
        modifier = Modifier.statusBarsPadding(),
        color = Color(0xFFFFEA00)
    ) {
        Text(
            text = "Feed!"
        )
    }
}
