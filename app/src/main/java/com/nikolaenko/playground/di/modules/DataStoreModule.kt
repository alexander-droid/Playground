package com.nikolaenko.playground.di.modules

import android.content.Context
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.nikolaenko.playground.datastore.ThemeDataStoreImpl
import com.nikolaenko.playground.datastore.ThemeSerializer
import com.nikolaenko.playground.domain.datastore.ThemeDataStore
import com.nikolaenko.playground.domain.dispatchers.AppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@Module
@InstallIn(ActivityComponent::class)
object DataStoreModule {

    @Provides
    fun themeDataStore(
        @ApplicationContext context: Context,
        dispatchers: AppDispatchers
    ): ThemeDataStore {
        return ThemeDataStoreImpl(
            dataStore = DataStoreFactory.create(
                serializer = ThemeSerializer,
                produceFile = { context.dataStoreFile("Theme") },
                corruptionHandler = null,
                migrations = listOf(),
                scope = CoroutineScope(dispatchers.io + SupervisorJob())
            )
        )
    }
}