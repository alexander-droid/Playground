package com.nikolaenko.playground.feed.ui.feed

import androidx.lifecycle.ViewModel
import com.nikolaenko.playground.core.delegates.ErrorHandler
import com.nikolaenko.playground.core.delegates.LoadingHandler
import com.nikolaenko.playground.core.delegates.StateHandler
import com.nikolaenko.playground.core.viewmodel.launch
import com.nikolaenko.playground.core.viewmodel.launchInitial
import com.nikolaenko.playground.feed.domain.model.FeedData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class FeedViewModelImpl @Inject constructor(
    private val stateHandler: StateHandler<FeedData>,
    private val errorHandler: ErrorHandler,
    private val loadingHandler: LoadingHandler,
) : ViewModel(),
    StateHandler<FeedData> by stateHandler,
    ErrorHandler by errorHandler,
    LoadingHandler by loadingHandler {



    init {
        launchInitial {
            updateState {
                FeedData("Feed title")
            }
        }
    }

    fun likePost(id: String) {
        launch {

        }
    }
}