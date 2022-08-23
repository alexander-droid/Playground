package com.nikolaenko.playground

import com.nikolaenko.core.viewmodel.BaseViewModel
import com.nikolaenko.settings.domain.datastore.ThemeDataStore
import com.nikolaenko.settings.domain.model.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class MainViewModel : BaseViewModel() {
    abstract val state: StateFlow<State>

    data class State(
        val isDarkTheme: Boolean = false
    )

    abstract fun toggleDarkMode()
}

class MainViewModelImpl(
    private val themeDataStore: ThemeDataStore
) : MainViewModel() {

    override val state = MutableStateFlow(State())

    init {
        launch {
            themeDataStore.flow.collect {
                state.value = State(isDarkTheme = it.isDark)
            }
        }
    }

    override fun toggleDarkMode() {
        launch {
            themeDataStore.update(
                Theme(
                    isDark = !state.value.isDarkTheme
                )
            )
        }
    }
}
