package com.nikolaenko.playground.auth.ui.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.nikolaenko.playground.core.logger.Logger

@Composable
fun Register() {
    val lifecycleOwner = LocalLifecycleOwner.current
    val observer = object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            Logger.d("Register onCreate")
        }

        override fun onDestroy(owner: LifecycleOwner) {
            Logger.d("Register onDestroy")
        }

        override fun onResume(owner: LifecycleOwner) {
            Logger.d("Register onResume")
        }

        override fun onPause(owner: LifecycleOwner) {
            Logger.d("Register onPause")
        }
    }
    LaunchedEffect(key1 = "register", block = {
        Logger.d("Register LaunchedEffect")
        lifecycleOwner.lifecycle.addObserver(observer)
    })
    DisposableEffect(key1 = "register", effect = {
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            Logger.d("Register DisposableEffect onDispose")
        }
    })

}