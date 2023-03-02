package com.nikolaenko.playground.profile.di

import com.nikolaenko.playground.core.delegates.DefaultStateHandler
import com.nikolaenko.playground.core.delegates.StateHandler
import com.nikolaenko.playground.profile.domain.model.Profile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DelegatesModule {

    @Provides
    fun defaultStateHandler(): StateHandler<Profile> {
        return DefaultStateHandler()
    }
}