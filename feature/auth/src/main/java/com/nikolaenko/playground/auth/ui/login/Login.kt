package com.nikolaenko.playground.auth.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.nikolaenko.playground.auth.R
import com.nikolaenko.playground.core.ui.AppButton

@Composable
internal fun Login(
    onLoggedIn: () -> Unit,
    goToRegister: () -> Unit,
    goToResetPassword: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppButton(onClick = onLoggedIn, text = stringResource(id = R.string.login))
        AppButton(onClick = goToRegister, text = stringResource(id = R.string.register))
        AppButton(onClick = goToResetPassword, text = stringResource(id = R.string.forgot_password))
    }
}

@Preview
@Composable
internal fun LoginPreview() {
    Login({}, {}, {})
}