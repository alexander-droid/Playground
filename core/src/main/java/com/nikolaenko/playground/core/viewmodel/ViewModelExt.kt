package com.nikolaenko.playground.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolaenko.playground.core.delegates.ErrorHandler
import com.nikolaenko.playground.core.delegates.LoadingHandler
import com.nikolaenko.playground.core.model.LoadingState
import com.nikolaenko.playground.core.logger.Logger
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun <T> T.launchInitial(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job where T : ViewModel, T : ErrorHandler, T: LoadingHandler {
    return viewModelScope.launch(context, start) {
        try {
            updateLoadingState(LoadingState(isLoading = true))
            block()
        } catch (exc: Exception) {
            Logger.e(exc)
            consumeException(exc)
        } finally {
            updateLoadingState(LoadingState(isLoading = false))
        }
    }
}

fun <T> T.launch(
    loading: MutableStateFlow<Boolean>? = null,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job where T : ViewModel, T : ErrorHandler {
    return viewModelScope.launch(context, start) {
        try {
            loading?.emit(true)
            block()
        } catch (exc: Exception) {
            Logger.e(exc)
            consumeException(exc)
        } finally {
            loading?.emit(false)
        }
    }
}