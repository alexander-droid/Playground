package com.nikolaenko.settings.di

import com.nikolaenko.settings.di.modules.dataStoreModule
import com.nikolaenko.settings.di.modules.viewModelModule

val settingsModules = listOf(
    viewModelModule,
    dataStoreModule
)