package com.nikolaenko.playground.core.delegates

import android.content.Context
import androidx.compose.runtime.Stable
import com.nikolaenko.playground.core.R
import com.nikolaenko.playground.core.domain.model.alert.ErrorMessage
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface ErrorHandler {

    val errorFlow: StateFlow<ErrorMessage?>

    val errorEvent: SharedFlow<ErrorMessage?>

    suspend fun consumeException(throwable: Throwable)

    suspend fun updateError(message: ErrorMessage?)
}

@Stable
class DefaultErrorHandler(
    private val context: Context
) : ErrorHandler {

    override val errorFlow = StableFlow(MutableStateFlow<ErrorMessage?>(null))

    override val errorEvent = StableEventFlow(MutableSharedFlow<ErrorMessage?>())

    override suspend fun consumeException(throwable: Throwable) {
        updateError(
            ErrorMessage(
                message = throwable.localizedMessage ?: context.getString(R.string.error_unknown),
                type = ErrorMessage.Type.ERROR
            )
        )
    }

    override suspend fun updateError(message: ErrorMessage?) {
        errorFlow.emit(message)
        errorEvent.emit(message)
    }
}

@Stable
class StableFlow<T>(stateFlow: MutableStateFlow<T>): MutableStateFlow<T> by stateFlow

@Stable
class StableEventFlow<T>(stateFlow: MutableSharedFlow<T>): MutableSharedFlow<T> by stateFlow