package com.nikolaenko.playground

import android.util.Log
import com.nikolaenko.core.ui.BaseViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class MainViewModel : BaseViewModel() {
    abstract val state: StateFlow<State>

    data class State(
        val isDarkTheme: Boolean = true
    )

    abstract fun toggleDarkMode()
}

class MainViewModelImpl @Inject constructor() : MainViewModel() {

    override val state = MutableStateFlow(State())

    init {
        Log.d("dfgdgf", "init")
        launch {
            delay(3000)
            state.emit(State(true))
        }
    }

    override fun toggleDarkMode() {
        launch {
            state.emit(state.value.copy(isDarkTheme = !state.value.isDarkTheme))
        }
    }
}
