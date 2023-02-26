package com.nikolaenko.playground.questionnaire.ui.questions.info

import com.nikolaenko.playground.core.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
internal class InfoViewModel @Inject constructor(

) : BaseViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    fun setFirstName(text: String) {
        _state.value = state.value.copy(firstName = text)
    }

    fun setLastName(text: String) {
        _state.value = state.value.copy(lastName = text)
    }

    fun setMiddleName(text: String) {
        _state.value = state.value.copy(middleName = text)
    }

    data class State(
        val firstName: String = "",
        val lastName: String = "",
        val middleName: String = "",
    )
}