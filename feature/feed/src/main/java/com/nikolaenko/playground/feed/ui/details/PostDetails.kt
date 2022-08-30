package com.nikolaenko.playground.feed.ui.details

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PostDetails() {
    Text(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        text = "Details"
    )
}