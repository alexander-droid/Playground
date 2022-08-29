package com.nikolaenko.playground.di

import com.nikolaenko.utils.dispatchers.AppDispatchers
import com.nikolaenko.utils.dispatchers.AppDispatchersImpl
import org.koin.dsl.module

val threadingModule = module {
    single<AppDispatchers> { AppDispatchersImpl() }
}