package com.nikolaenko.playground.di.modules

import androidx.lifecycle.ViewModel
import com.nikolaenko.playground.MainViewModel
import com.nikolaenko.playground.MainViewModelImpl
import com.nikolaenko.playground.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityComponent::class)
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModelImpl): ViewModel
}