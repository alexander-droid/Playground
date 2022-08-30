package com.nikolaenko.playground.chat.di.modules

import com.nikolaenko.playground.chat.ui.ChatViewModel
import com.nikolaenko.playground.chat.ui.ChatViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<ChatViewModel> { ChatViewModelImpl() }
}