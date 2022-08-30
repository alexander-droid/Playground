package com.nikolaenko.playground.feed.ui.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.nikolaenko.playground.feed.R

@Composable
fun Feed(
    goToDetails: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color(0xFF2196F3)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = stringResource(id = R.string.feed))
        Button(onClick = goToDetails) {
            Text(text = stringResource(id = R.string.go_to_details))
        }
    }
}