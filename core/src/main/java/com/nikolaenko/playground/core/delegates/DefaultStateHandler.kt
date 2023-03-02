package com.nikolaenko.playground.core.delegates

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface StateHandler<S> {

    val stateFlow: StateFlow<S?>

    suspend fun updateState(copyState: (S?) -> S?)
}

class DefaultStateHandler<S>: StateHandler<S> {

    override val stateFlow = MutableStateFlow<S?>(null)

    override suspend fun updateState(copyState: (S?) -> S?) {
        this.stateFlow.emit(copyState(stateFlow.value))
    }
}