package com.nikolaenko.feed.di.modules

import com.nikolaenko.feed.ui.FeedViewModel
import com.nikolaenko.feed.ui.FeedViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<FeedViewModel> { FeedViewModelImpl() }
}