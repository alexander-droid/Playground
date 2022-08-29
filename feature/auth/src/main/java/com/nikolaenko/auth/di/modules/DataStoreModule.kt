package com.nikolaenko.auth.di.modules

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.nikolaenko.core.data.datastore.UserSessionDataStoreImpl
import com.nikolaenko.core.data.serializer.UserSessionSerializer
import com.nikolaenko.core.domain.datastore.UserSessionDataStore
import com.nikolaenko.utils.dispatchers.AppDispatchers
import com.nikolaenko.utils.utils.C
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single<UserSessionDataStore> {
        UserSessionDataStoreImpl(
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