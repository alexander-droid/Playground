package com.nikolaenko.playground.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkHttpModule {

    @Provides
    @UnauthorizedClient
    @Singleton
    fun provideUnauthorizedOkHttpClient(

    ): OkHttpClient = OkHttpClient.Builder()
        .apply {

        }.build()

    @Provides
    @AuthorizedClient
    @Singleton
    fun provideAuthorizedOkHttpClient(

    ): OkHttpClient = OkHttpClient.Builder()
        .apply {

        }.build()
}