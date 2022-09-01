package com.nikolaenko.playground.core.di.modules

import com.nikolaenko.playground.core.data.dispatchers.AppDispatchersImpl
import com.nikolaenko.playground.core.domain.dispatchers.AppDispatchers
import org.koin.dsl.module

val threadingModule = module {
    single<AppDispatchers> { AppDispatchersImpl() }
}