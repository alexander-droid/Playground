package com.nikolaenko.feed.ui

import android.content.Context
import com.nikolaenko.core.viewmodel.BaseViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

abstract class FeedViewModel: BaseViewModel() {
}

class FeedViewModelImpl @Inject constructor(): FeedViewModel() {

    init {

    }
}