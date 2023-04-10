package com.nikolaenko.playground.core.delegates

import com.nikolaenko.playground.core.domain.model.LoadingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface LoadingHandler {

    val loadingFlow: StateFlow<LoadingState>

    suspend fun updateLoadingState(state: LoadingState)
}

class DefaultLoadingHandler: LoadingHandler {

    override val loadingFlow = MutableStateFlow(LoadingState(isLoading = false))

    override suspend fun updateLoadingState(state: LoadingState) {
        loadingFlow.emit(state)
    }
}