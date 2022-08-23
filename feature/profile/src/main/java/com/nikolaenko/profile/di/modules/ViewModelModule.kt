package com.nikolaenko.profile.di.modules

import com.nikolaenko.profile.ui.ProfileViewModel
import com.nikolaenko.profile.ui.ProfileViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<ProfileViewModel> { ProfileViewModelImpl() }
}