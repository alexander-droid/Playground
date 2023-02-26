package com.nikolaenko.playground.questionnaire.ui.questions.multi_select

import com.nikolaenko.playground.core.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
internal class MultiSelectViewModel @Inject constructor(

) : BaseViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    fun select(selected: State.Item) {
        launch {
            _state.value = state.value.copy(
                list = state.value.list.map {
                    if (selected.id == it.id) {
                        it.copy(isSelected = !selected.isSelected)
                    } else {
                        it
                    }
                }
            )
        }
    }

    data class State(
        val list: List<Item> = mutableListOf<Item>().apply {
            repeat(20) {
                add(
                    Item(
                        name = "Question item number $it",
                        isSelected = false
                    )
                )
            }
        }
    ) {
        data class Item(
            val id: String = UUID.randomUUID().toString(),
            val name: String,
            val isSelected: Boolean
        )
    }
}