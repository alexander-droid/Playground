package com.nikolaenko.playground.core.di

import com.nikolaenko.playground.core.BuildConfig
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @AuthorizedClient
    @Singleton
    fun provideAuthorizedRetrofitClient(
        moshi: Moshi,
        @AuthorizedClient okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://test.com"/*BuildConfig.SERVER_URL*/) //TODO
        .client(okHttpClient)
        .build()

    @Provides
    @UnauthorizedClient
    @Singleton
    fun provideUnauthorizedRetrofitClient(
        moshi: Moshi,
        @UnauthorizedClient okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://test.com"/*BuildConfig.SERVER_URL*/) //TODO
        .client(okHttpClient)
        .build()
}