package com.nikolaenko.auth.di.modules

import com.nikolaenko.auth.ui.forgot.ForgotPasswordViewModel
import com.nikolaenko.auth.ui.forgot.ForgotPasswordViewModelImpl
import com.nikolaenko.auth.ui.login.LoginViewModel
import com.nikolaenko.auth.ui.login.LoginViewModelImpl
import com.nikolaenko.auth.ui.register.RegisterViewModel
import com.nikolaenko.auth.ui.register.RegisterViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<LoginViewModel> { LoginViewModelImpl() }
    viewModel<RegisterViewModel> { RegisterViewModelImpl() }
    viewModel<ForgotPasswordViewModel> { ForgotPasswordViewModelImpl() }
}