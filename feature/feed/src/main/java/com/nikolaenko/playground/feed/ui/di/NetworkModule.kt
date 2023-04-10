package com.nikolaenko.playground.feed.ui.di

import com.nikolaenko.playground.core.di.AuthorizedClient
import com.nikolaenko.playground.feed.data.network.FeedApi
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
    @AuthorizedClient
    fun provideApiAddressSearch(
        @AuthorizedClient retrofit: Retrofit
    ): FeedApi = retrofit.create(FeedApi::class.java)

}
