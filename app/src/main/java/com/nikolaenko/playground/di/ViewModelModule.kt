package com.nikolaenko.playground.di

import com.nikolaenko.playground.MainViewModel
import com.nikolaenko.playground.MainViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<MainViewModel> { MainViewModelImpl(get(), get()) }
}