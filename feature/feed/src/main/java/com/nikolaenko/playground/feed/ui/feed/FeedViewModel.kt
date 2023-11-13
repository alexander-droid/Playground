package com.nikolaenko.playground.feed.ui.feed

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.nikolaenko.playground.core.delegates.ErrorHandler
import com.nikolaenko.playground.core.delegates.LoadingHandler
import com.nikolaenko.playground.core.delegates.StateHandler
import com.nikolaenko.playground.core.viewmodel.launch
import com.nikolaenko.playground.feed.data.datasource.FeedDataSource
import com.nikolaenko.playground.feed.domain.model.FeedData
import com.nikolaenko.playground.feed.domain.repository.FeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class FeedViewModel @Inject constructor(
    private val stateHandler: StateHandler<FeedData>,
    private val errorHandler: ErrorHandler,
    private val loadingHandler: LoadingHandler,
    private val feedRepository: FeedRepository
) : ViewModel(),
    StateHandler<FeedData> by stateHandler,
    ErrorHandler by errorHandler,
    LoadingHandler by loadingHandler {

    val feed = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { FeedDataSource(feedRepository) }
    ).flow

    init {
        launch {
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