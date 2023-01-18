package com.nikolaenko.playground.core.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun AppButton(
    onClick: () -> Unit,
    text: String
) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}

@Composable
fun AppTextButton(
    onClick: () -> Unit,
    text: String
) {
    TextButton(onClick = onClick) {
        Text(text = text)
    }
}