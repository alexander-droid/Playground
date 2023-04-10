package com.nikolaenko.playground.profile.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolaenko.playground.core.delegates.ErrorHandler
import com.nikolaenko.playground.core.delegates.LoadingHandler
import com.nikolaenko.playground.core.delegates.StateHandler
import com.nikolaenko.playground.core.viewmodel.launchInitial
import com.nikolaenko.playground.profile.domain.model.Profile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    private val stateHandler: StateHandler<Profile>,
    private val errorHandler: ErrorHandler,
    private val loadingHandler: LoadingHandler,
) : ViewModel(),
    StateHandler<Profile> by stateHandler,
    ErrorHandler by errorHandler,
    LoadingHandler by loadingHandler {

    init {
        launchInitial {
            delay(3000)
            consumeException(RuntimeException("Test 0 error"))
        }

        viewModelScope.launch {
            delay(6000)
            this@ProfileViewModel.launchInitial {
                delay(3000)
                updateState {
                    Profile(
                        name = "My name",
                        email = "email@mail.com",
                        avatar = "https://i.ytimg.com/vi/6I4TN185Szw/maxresdefault.jpg"
                    )
                }
            }
        }

//        viewModelScope.launch {
//            delay(12000)
//            this@ProfileViewModel.launch {
//                delay(3000)
//                throw RuntimeException("Test 2 error")
//            }
//        }
    }
}
