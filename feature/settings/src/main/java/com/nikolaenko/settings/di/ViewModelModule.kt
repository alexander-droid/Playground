package com.nikolaenko.settings.di

import androidx.lifecycle.ViewModel
import com.nikolaenko.core.viewmodel.ViewModelKey
import com.nikolaenko.settings.ui.SettingsViewModel
import com.nikolaenko.settings.ui.SettingsViewModelImpl
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
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindMainViewModel(viewModel: SettingsViewModelImpl): ViewModel
}