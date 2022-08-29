package com.nikolaenko.auth.di

import com.nikolaenko.auth.di.modules.dataStoreModule
import com.nikolaenko.auth.di.modules.viewModelModule

val authModules = listOf(
    viewModelModule,
    dataStoreModule
)