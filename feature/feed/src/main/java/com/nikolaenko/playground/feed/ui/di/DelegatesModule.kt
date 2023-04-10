package com.nikolaenko.playground.feed.ui.di

import com.nikolaenko.playground.core.delegates.DefaultStateHandler
import com.nikolaenko.playground.core.delegates.StateHandler
import com.nikolaenko.playground.feed.domain.model.FeedData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DelegatesModule {

    @Provides
    fun defaultStateHandler(): StateHandler<FeedData> {
        return DefaultStateHandler()
    }
}