package com.nikolaenko.playground.profile.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun SettingsScreen() {
    Column(
        modifier = Modifier.statusBarsPadding().fillMaxSize()
    ) {
        Text(
            text = "Settings"
        )
    }
}
