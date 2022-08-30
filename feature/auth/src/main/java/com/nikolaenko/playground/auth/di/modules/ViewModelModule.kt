package com.nikolaenko.playground.auth.di.modules

import com.nikolaenko.playground.auth.ui.forgot.ForgotPasswordViewModel
import com.nikolaenko.playground.auth.ui.forgot.ForgotPasswordViewModelImpl
import com.nikolaenko.playground.auth.ui.login.LoginViewModel
import com.nikolaenko.playground.auth.ui.login.LoginViewModelImpl
import com.nikolaenko.playground.auth.ui.register.RegisterViewModel
import com.nikolaenko.playground.auth.ui.register.RegisterViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<LoginViewModel> { LoginViewModelImpl() }
    viewModel<RegisterViewModel> { RegisterViewModelImpl() }
    viewModel<ForgotPasswordViewModel> { ForgotPasswordViewModelImpl() }
}