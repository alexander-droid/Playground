package com.nikolaenko.profile.di

import androidx.lifecycle.ViewModel
import com.nikolaenko.core.viewmodel.ViewModelKey
import com.nikolaenko.profile.ui.ProfileViewModel
import com.nikolaenko.profile.ui.ProfileViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindMainViewModel(viewModel: ProfileViewModelImpl): ViewModel
}
