package com.nikolaenko.playground.auth.ui.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun Register() {
    Column(
        modifier = Modifier.statusBarsPadding().fillMaxSize()
    ) {
        Text(
            text = "Register"
        )
    }
}