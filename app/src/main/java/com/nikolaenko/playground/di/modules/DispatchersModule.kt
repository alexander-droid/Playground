package com.nikolaenko.playground.di.modules

import com.nikolaenko.playground.data.dispatchers.AppDispatchersImpl
import com.nikolaenko.playground.domain.dispatchers.AppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object DispatchersModule {

    @Provides
    fun provideDispatchers(): AppDispatchers {
        return AppDispatchersImpl()
    }
}