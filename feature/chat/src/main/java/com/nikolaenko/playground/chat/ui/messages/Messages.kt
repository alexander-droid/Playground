package com.nikolaenko.playground.chat.ui.messages

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Messages() {
    Text(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        text = "Messages"
    )
}