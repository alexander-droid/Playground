package com.nikolaenko.settings.di

import android.content.Context
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.nikolaenko.core.utils.C
import com.nikolaenko.core.dispatchers.AppDispatchers
import com.nikolaenko.settings.data.datastore.ThemeDataStoreImpl
import com.nikolaenko.settings.data.datastore.ThemeSerializer
import com.nikolaenko.settings.domain.datastore.ThemeDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun themeDataStore(
        @ApplicationContext context: Context,
        dispatchers: AppDispatchers
    ): ThemeDataStore {
        return ThemeDataStoreImpl(
            dataStore = DataStoreFactory.create(
                serializer = ThemeSerializer,
                produceFile = { context.dataStoreFile(C.DATASTORE_THEME_NAME) },
                corruptionHandler = null,
                migrations = listOf(),
                scope = CoroutineScope(dispatchers.io + SupervisorJob())
            )
        )
    }
}