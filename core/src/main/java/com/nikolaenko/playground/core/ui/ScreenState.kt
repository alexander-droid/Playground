package com.nikolaenko.playground.core.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nikolaenko.playground.core.delegates.ErrorHandler
import com.nikolaenko.playground.core.delegates.LoadingHandler
import com.nikolaenko.playground.core.delegates.StateHandler

@Composable
fun <T> ScreenState(
    stateHandler: T,
    loadingContent: @Composable () -> Unit = { LoadingContent() },
    errorContent: @Composable (ErrorHandler) -> Unit = { ErrorContent(it) },
    errorIndicator: @Composable (ErrorHandler) -> Unit = { ErrorIndicator(it) },
    loadingIndicator: @Composable () -> Unit = { LoadingIndicator() },
    content: @Composable () -> Unit
) where T : StateHandler<*>, T : LoadingHandler, T : ErrorHandler {
    val contentState by stateHandler.stateFlow.collectAsState()
    val initialLoadingState by stateHandler.loadingFlow.collectAsState()
    val errorState = stateHandler.errorFlow.collectAsState().value

    Log.d("wefgrshtrjy", "------------")
    Log.d(
        "wefgrshtrjy",
        "State: $contentState\nLoading: $initialLoadingState\nError: $errorState"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        if (contentState != null) {
            content()
            errorIndicator(stateHandler)
        } else if (errorState != null) {
            Log.d("wefgrshtrjy", "errorContent")
            errorContent(stateHandler)
        } else if (initialLoadingState.isLoading) {
            loadingContent()
        }

        if (initialLoadingState.isLoading && (contentState != null || errorState != null)) {
            loadingIndicator()
        }
    }
}

@Composable
private fun LoadingContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun ErrorContent(errorHandler: ErrorHandler) {
    Log.d("wefgrshtrjy", "ErrorContent")
    val errorMessage by errorHandler.errorFlow.collectAsState()
    Log.d("wefgrshtrjy", "errorMessage $errorMessage")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = errorMessage?.message ?: "")
    }
}

@Composable
private fun LoadingIndicator() {
    Box(modifier = Modifier.fillMaxSize()) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun ErrorIndicator(errorHandler: ErrorHandler) {
    Box(modifier = Modifier.fillMaxSize()) {

        val snackbarHostState = remember { SnackbarHostState() }

        LaunchedEffect(Unit) {
            errorHandler.errorEvent.collect { error ->
                if (error != null) {
                    snackbarHostState.showSnackbar(error.message)
                }
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
        )
    }
}