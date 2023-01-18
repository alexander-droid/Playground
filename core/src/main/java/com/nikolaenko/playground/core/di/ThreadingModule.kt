package com.nikolaenko.playground.core.di

import com.nikolaenko.playground.core.data.dispatchers.AppDispatchersImpl
import com.nikolaenko.playground.core.domain.dispatchers.AppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ThreadingModule {

    @Provides
    @Singleton
    fun AppDispatchers(): AppDispatchers {
        return AppDispatchersImpl()
    }
}