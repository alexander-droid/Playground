package com.nikolaenko.playground

import com.nikolaenko.core.domain.datastore.ThemeDataStore
import com.nikolaenko.core.domain.datastore.UserSessionDataStore
import com.nikolaenko.utils.logger.Logger
import com.nikolaenko.utils.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class MainViewModel : BaseViewModel() {
    abstract val state: StateFlow<State>

    data class State(
        val isDarkTheme: Boolean? = null,
        val isLoggedIn: Boolean? = null
    )

    abstract fun toggleDarkMode()
}

class MainViewModelImpl(
    private val themeDataStore: ThemeDataStore,
    private val userSessionDataStore: UserSessionDataStore
) : MainViewModel() {

    override val state = MutableStateFlow(State())

    init {
        launch {
            themeDataStore.flow.collect {
                Logger.d("collect theme $it")
                state.value = state.value.copy(
                    isDarkTheme = it.isDark
                )
            }
        }

        launch {
            userSessionDataStore.flow.collect {
                Logger.d("collect session $it")
                state.value = state.value.copy(
                    isLoggedIn = it.isLoggedIn
                )
            }
        }
    }

    override fun toggleDarkMode() {
        launch {
            val isDarkTheme = state.value.isDarkTheme ?: return@launch
            themeDataStore.update(
                com.nikolaenko.core.domain.model.Theme(
                    isDark = !isDarkTheme
                )
            )
        }
    }
}
