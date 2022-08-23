package com.nikolaenko.settings.di.modules

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.nikolaenko.core.dispatchers.AppDispatchers
import com.nikolaenko.core.utils.C
import com.nikolaenko.settings.data.datastore.ThemeDataStoreImpl
import com.nikolaenko.settings.data.datastore.ThemeSerializer
import com.nikolaenko.settings.domain.datastore.ThemeDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single<ThemeDataStore> {
        ThemeDataStoreImpl(
            dataStore = DataStoreFactory.create(
                serializer = ThemeSerializer,
                produceFile = { androidContext().dataStoreFile(C.DATASTORE_THEME_NAME) },
                corruptionHandler = null,
                migrations = listOf(),
                scope = CoroutineScope(get<AppDispatchers>().io + SupervisorJob())
            )
        )
    }
}