package com.nikolaenko.playground.auth.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.nikolaenko.playground.auth.R
import com.nikolaenko.playground.core.logger.Logger
import com.nikolaenko.playground.core.ui.AppButton

@Composable
internal fun Login(
    onLoggedIn: () -> Unit,
    goToRegister: () -> Unit,
    goToResetPassword: () -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val observer = object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            Logger.d("Login onCreate")
        }

        override fun onDestroy(owner: LifecycleOwner) {
            Logger.d("Login onDestroy")
        }

        override fun onResume(owner: LifecycleOwner) {
            Logger.d("Login onResume")
        }

        override fun onPause(owner: LifecycleOwner) {
            Logger.d("Login onPause")
        }
    }
    LaunchedEffect(key1 = "login", block = {
        Logger.d("Login LaunchedEffect")
        lifecycleOwner.lifecycle.addObserver(observer)
    })
    DisposableEffect(key1 = "login", effect = {
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            Logger.d("Login DisposableEffect onDispose")
        }
    })

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