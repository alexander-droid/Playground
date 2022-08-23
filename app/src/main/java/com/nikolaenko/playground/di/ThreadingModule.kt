package com.nikolaenko.playground.di

import com.nikolaenko.core.dispatchers.AppDispatchers
import com.nikolaenko.core.dispatchers.AppDispatchersImpl
import org.koin.dsl.module

val threadingModule = module {
    single<AppDispatchers> { AppDispatchersImpl() }
}