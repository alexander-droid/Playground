package com.nikolaenko.playground.feed.di

import com.nikolaenko.playground.feed.data.network.FeedApi
import com.nikolaenko.playground.feed.data.repository.FeedRepositoryImpl
import com.nikolaenko.playground.feed.domain.repository.FeedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun feedRepository(api: FeedApi): FeedRepository {
        return FeedRepositoryImpl(api)
    }
}