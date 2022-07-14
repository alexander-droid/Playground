package com.nikolaenko.playground.di.modules

import com.nikolaenko.core.dispatchers.AppDispatchersImpl
import com.nikolaenko.core.dispatchers.AppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
open class DispatchersModule {

    @Provides
    @Singleton
    fun provideDispatchers(): AppDispatchers {
        return AppDispatchersImpl()
    }
}