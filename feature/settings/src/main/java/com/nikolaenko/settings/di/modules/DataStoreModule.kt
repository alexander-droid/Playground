package com.nikolaenko.settings.di.modules

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.nikolaenko.core.data.datastore.ThemeDataStoreImpl
import com.nikolaenko.core.data.serializer.ThemeSerializer
import com.nikolaenko.core.domain.datastore.ThemeDataStore
import com.nikolaenko.utils.dispatchers.AppDispatchers
import com.nikolaenko.utils.utils.C
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