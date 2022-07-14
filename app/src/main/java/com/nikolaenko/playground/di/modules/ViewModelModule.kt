package com.nikolaenko.playground.di.modules

import androidx.lifecycle.ViewModel
import com.nikolaenko.core.viewmodel.ViewModelKey
import com.nikolaenko.playground.MainViewModel
import com.nikolaenko.playground.MainViewModelImpl
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
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModelImpl): ViewModel
}
