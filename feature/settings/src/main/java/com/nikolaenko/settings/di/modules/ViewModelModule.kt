package com.nikolaenko.settings.di.modules

import com.nikolaenko.settings.ui.SettingsViewModel
import com.nikolaenko.settings.ui.SettingsViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<SettingsViewModel> { SettingsViewModelImpl() }
}