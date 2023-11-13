package com.nikolaenko.playground.profile.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.nikolaenko.playground.core.ui.ScreenState

@Composable
internal fun ProfileScreen() {

    val viewModel = hiltViewModel<ProfileViewModel>()
    val state by viewModel.stateFlow.collectAsState()
    ScreenState(viewModel) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = state?.avatar,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = state?.name.orEmpty()
            )
            Text(
                text = state?.email.orEmpty()
            )
        }
    }
}

@Composable
@Preview
internal fun ProfilePreview() {
    Surface {
        ProfileScreen()
    }
}