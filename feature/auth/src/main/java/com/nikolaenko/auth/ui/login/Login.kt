package com.nikolaenko.auth.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
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
import com.nikolaenko.auth.R
import com.nikolaenko.utils.logger.Logger

@Composable
fun Login(
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
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = onLoggedIn) {
            Text(text = stringResource(id = R.string.login))
        }
        Button(onClick = goToRegister) {
            Text(text = stringResource(id = R.string.register))
        }
        Button(onClick = goToResetPassword) {
            Text(text = stringResource(id = R.string.forgot_password))
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    Login({}, {}, {})
}