package com.nikolaenko.feed.di

import androidx.lifecycle.ViewModel
import com.nikolaenko.core.viewmodel.ViewModelKey
import com.nikolaenko.feed.ui.FeedViewModel
import com.nikolaenko.feed.ui.FeedViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    abstract fun bindMainViewModel(viewModel: FeedViewModelImpl): ViewModel
}
