package com.nikolaenko.playground.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun DrawerContent(onThemeChanged: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier
            .align(Alignment.End)
            .statusBarsPadding()) {
            IconButton(onClick = onThemeChanged) {
                Icon(Icons.Default.LightMode, contentDescription = "Localized description")
            }
        }
    }
}
