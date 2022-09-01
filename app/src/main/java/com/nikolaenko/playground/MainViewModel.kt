package com.nikolaenko.playground

import com.nikolaenko.playground.core.domain.datastore.ThemeRepository
import com.nikolaenko.playground.core.domain.datastore.UserSessionRepository
import com.nikolaenko.playground.core.domain.model.Theme
import com.nikolaenko.playground.core.logger.Logger
import com.nikolaenko.playground.core.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class MainViewModel : BaseViewModel() {
    abstract val state: StateFlow<State>

    data class State(
        val isDarkTheme: Boolean? = null,
        val isLoggedIn: Boolean? = null
    )

    abstract fun toggleDarkMode(isSystemInDarkTheme: Boolean)
}

class MainViewModelImpl(
    private val themeRepository: ThemeRepository,
    private val userSessionRepository: UserSessionRepository
) : MainViewModel() {

    override val state = MutableStateFlow(State())

    init {
        launch {
            themeRepository.flow.collect {
                Logger.d("collect theme $it")
                state.value = state.value.copy(
                    isDarkTheme = it.isDark
                )
            }
        }

        launch {
            userSessionRepository.flow.collect {
                Logger.d("collect session $it")
                state.value = state.value.copy(
                    isLoggedIn = it.isLoggedIn
                )
            }
        }
    }

    override fun toggleDarkMode(isSystemInDarkTheme: Boolean) {
        launch {
            val isDarkTheme = state.value.isDarkTheme ?: isSystemInDarkTheme
            themeRepository.update(
                Theme(
                    isDark = !isDarkTheme
                )
            )
        }
    }
}
