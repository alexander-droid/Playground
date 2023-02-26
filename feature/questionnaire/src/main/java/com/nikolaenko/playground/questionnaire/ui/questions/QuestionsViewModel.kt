package com.nikolaenko.playground.questionnaire.ui.questions

import com.nikolaenko.playground.core.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
internal class QuestionsViewModel @Inject constructor(

): BaseViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    private val _exit = MutableSharedFlow<Unit>()
    val exit = _exit.asSharedFlow()

    private val _navigate = MutableSharedFlow<Nav>()
    val navigate = _navigate.asSharedFlow()

    fun onNextQuestion() = launch {
        val nextIndex = state.value.currentScreenIndex + 1
        if (nextIndex <= state.value.screenCount - 1) {
            _state.value = _state.value.copy(
                currentScreenIndex = nextIndex
            )
            _navigate.emit(Nav.Forward(nextIndex))
        }
    }

    fun onPrevQuestion() = launch {
        val prevIndex = state.value.currentScreenIndex - 1
        if (prevIndex == -1) {
            _exit.emit(Unit)
        } else {
            _state.value = _state.value.copy(
                currentScreenIndex = prevIndex
            )
            _navigate.emit(Nav.Back(prevIndex))
        }
    }

    data class State(
        val currentScreenIndex: Int = 0
    ) {

        val questions = listOf(
            QuestionScreen.SingleSelect,
            QuestionScreen.MultiSelect,
            QuestionScreen.Info,
            QuestionScreen.Confirm,
        )

        val screenCount = questions.size

        val canGoNext = currentScreenIndex < questions.lastIndex
        val canGoPrev = currentScreenIndex > 0
    }

    sealed class Nav {

        abstract val index: Int

        data class Forward(override val index: Int): Nav()
        data class Back(override val index: Int): Nav()
    }
}