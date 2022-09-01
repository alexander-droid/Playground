package com.nikolaenko.playground.core.di.modules

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.nikolaenko.playground.core.data.repository.ThemeRepositoryImpl
import com.nikolaenko.playground.core.data.repository.UserSessionRepositoryImpl
import com.nikolaenko.playground.core.data.serializer.ThemeSerializer
import com.nikolaenko.playground.core.data.serializer.UserSessionSerializer
import com.nikolaenko.playground.core.domain.datastore.ThemeRepository
import com.nikolaenko.playground.core.domain.datastore.UserSessionRepository
import com.nikolaenko.playground.core.domain.dispatchers.AppDispatchers
import com.nikolaenko.playground.core.utils.C
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<ThemeRepository> {
        ThemeRepositoryImpl(
            dataStore = DataStoreFactory.create(
                serializer = ThemeSerializer,
                produceFile = { androidContext().dataStoreFile(C.DATASTORE_THEME_NAME) },
                corruptionHandler = null,
                migrations = listOf(),
                scope = CoroutineScope(get<AppDispatchers>().io + SupervisorJob())
            )
        )
    }
    single<UserSessionRepository> {
        UserSessionRepositoryImpl(
            dataStore = DataStoreFactory.create(
                serializer = UserSessionSerializer,
                produceFile = { androidContext().dataStoreFile(C.DATASTORE_USER_SESSION_NAME) },
                corruptionHandler = null,
                migrations = listOf(),
                scope = CoroutineScope(get<AppDispatchers>().io + SupervisorJob())
            )
        )
    }
}