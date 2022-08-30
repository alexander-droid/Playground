package com.nikolaenko.playground.chat.ui.contacts

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Contacts() {
    Text(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        text = "Contacts"
    )
}