package com.nikolaenko.playground.di

import com.nikolaenko.playground.core.domain.dispatchers.AppDispatchers
import com.nikolaenko.playground.core.data.dispatchers.AppDispatchersImpl
import org.koin.dsl.module

val threadingModule = module {
    single<AppDispatchers> { AppDispatchersImpl() }
}