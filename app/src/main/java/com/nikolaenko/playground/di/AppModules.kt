package com.nikolaenko.playground.di

import com.nikolaenko.playground.core.di.modules.threadingModule

val appModules = listOf(
    threadingModule,
    viewModelModule
)