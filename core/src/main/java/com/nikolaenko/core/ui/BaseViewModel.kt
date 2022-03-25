package com.nikolaenko.core.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    private val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.e("BaseViewModel", "errorHandler", throwable)
    }

    fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch(
            context = context + errorHandler,
            start = start,
            block = block
        )
    }
}
