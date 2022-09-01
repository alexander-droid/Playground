package com.nikolaenko.playground.auth.ui.forgot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun ForgotPassword() {
    Column(
        modifier = Modifier.statusBarsPadding().fillMaxSize()
    ) {
        Text(
            text = "Restore password"
        )
    }
}