package com.nikolaenko.playground.core.di

import android.content.Context
import com.nikolaenko.playground.core.delegates.DefaultErrorHandler
import com.nikolaenko.playground.core.delegates.DefaultLoadingHandler
import com.nikolaenko.playground.core.delegates.ErrorHandler
import com.nikolaenko.playground.core.delegates.LoadingHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object DelegatesModule {

    @Provides
    fun defaultErrorHandler(
        @ApplicationContext context: Context
    ): ErrorHandler {
        return DefaultErrorHandler(context)
    }

    @Provides
    fun defaultInitialLoadingHandler(): LoadingHandler {
        return DefaultLoadingHandler()
    }
}