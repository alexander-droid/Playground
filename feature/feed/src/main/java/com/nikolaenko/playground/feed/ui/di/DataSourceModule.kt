package com.nikolaenko.playground.feed.ui.di

import androidx.paging.PagingSource
import com.nikolaenko.playground.feed.data.datasource.FeedDataSource
import com.nikolaenko.playground.feed.domain.model.Post
import com.nikolaenko.playground.feed.domain.repository.FeedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataSourceModule {

    @Provides
    fun feedDataSource(feedRepository: FeedRepository): PagingSource<String, Post> {
        return FeedDataSource(repository = feedRepository)
    }
}