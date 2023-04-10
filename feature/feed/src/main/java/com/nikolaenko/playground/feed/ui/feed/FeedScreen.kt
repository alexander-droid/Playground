package com.nikolaenko.playground.feed.ui.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.nikolaenko.playground.feed.R

@Composable
internal fun FeedScreen(
    goToDetails: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = stringResource(id = R.string.feed))
        Button(onClick = goToDetails) {
            Text(text = stringResource(id = R.string.go_to_details))
        }
    }
}

@Preview
@Composable
private fun FeedPreview() {
    Surface {
        FeedScreen {

        }
    }
}