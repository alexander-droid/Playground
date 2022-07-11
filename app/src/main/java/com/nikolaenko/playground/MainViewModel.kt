package com.nikolaenko.playground

import com.nikolaenko.core.ui.BaseViewModel
import com.nikolaenko.playground.domain.datastore.ThemeDataStore
import com.nikolaenko.playground.domain.model.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber
import javax.inject.Inject

abstract class MainViewModel : BaseViewModel() {
    abstract val state: StateFlow<State>

    data class State(
        val isDarkTheme: Boolean = false
    )

    abstract fun toggleDarkMode()
}

class MainViewModelImpl @Inject constructor(
    private val themeDataStore: ThemeDataStore
) : MainViewModel() {

    override val state = MutableStateFlow(State())

    init {
        launch {
            themeDataStore.flow.collect {
                Timber.d("theme: $it")
                state.value = State(isDarkTheme = it.isDark)
            }
        }
    }

    override fun toggleDarkMode() {
        launch {
            Timber.d("update")
            themeDataStore.update(
                Theme(
                    isDark = !state.value.isDarkTheme
                )
            )
        }
    }
}
