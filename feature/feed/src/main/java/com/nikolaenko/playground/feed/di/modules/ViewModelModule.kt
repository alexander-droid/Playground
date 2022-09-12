package com.nikolaenko.playground.feed.di.modules

import com.nikolaenko.playground.feed.ui.feed.FeedViewModel
import com.nikolaenko.playground.feed.ui.feed.FeedViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModel<FeedViewModel> { FeedViewModelImpl() }
}