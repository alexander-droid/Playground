package com.nikolaenko.playground.feed.di

import com.nikolaenko.playground.core.di.AuthorizedClient
import com.nikolaenko.playground.core.di.MockClient
import com.nikolaenko.playground.feed.data.network.FeedApiMock
import com.nikolaenko.playground.feed.domain.network.FeedApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @MockClient
    fun provideFeedApiMock(): FeedApi = FeedApiMock()

    @Provides
    @Singleton
    @AuthorizedClient
    fun provideFeedApi(
        @AuthorizedClient retrofit: Retrofit
    ): FeedApi = retrofit.create(FeedApi::class.java)

}
