package com.nikolaenko.playground.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.insets.statusBarsPadding
import com.nikolaenko.playground.R

@Composable
fun DrawerContent(
    onThemeChanged: () -> Unit,
    goToProfile: () -> Unit,
    goToChat: () -> Unit,
    goToFeed: () -> Unit,
    goToQuestionnaire: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        IconButton(
            onClick = onThemeChanged,
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(Icons.Default.LightMode, contentDescription = null)
        }
        TextButton(
            onClick = goToProfile,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = stringResource(id = R.string.go_to_profile))
        }
        TextButton(
            onClick = goToChat,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = stringResource(id = R.string.go_to_chat))
        }
        TextButton(
            onClick = goToFeed,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = stringResource(id = R.string.go_to_feed))
        }
        TextButton(
            onClick = goToQuestionnaire,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = stringResource(id = R.string.go_to_questionnaire))
        }
    }
}
