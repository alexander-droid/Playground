package com.nikolaenko.playground.profile.di.modules

import com.nikolaenko.playground.profile.ui.ProfileViewModel
import com.nikolaenko.playground.profile.ui.ProfileViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<ProfileViewModel> { ProfileViewModelImpl() }
}