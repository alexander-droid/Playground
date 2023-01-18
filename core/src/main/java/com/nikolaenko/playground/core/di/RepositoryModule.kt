package com.nikolaenko.playground.core.di

import android.content.Context
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
object RepositoryModule {

    @Provides
    @Singleton
    fun ThemeRepository(
        @ApplicationContext context: Context,
        dispatchers: AppDispatchers
    ): ThemeRepository {
        return ThemeRepositoryImpl(
            dataStore = DataStoreFactory.create(
                serializer = ThemeSerializer,
                produceFile = { context.dataStoreFile(C.DATASTORE_THEME_NAME) },
                corruptionHandler = null,
                migrations = listOf(),
                scope = CoroutineScope(dispatchers.io + SupervisorJob())
            )
        )
    }

    @Provides
    @Singleton
    fun UserSessionRepository(
        @ApplicationContext context: Context,
        dispatchers: AppDispatchers
    ): UserSessionRepository {
        return UserSessionRepositoryImpl(
            dataStore = DataStoreFactory.create(
                serializer = UserSessionSerializer,
                produceFile = { context.dataStoreFile(C.DATASTORE_USER_SESSION_NAME) },
                corruptionHandler = null,
                migrations = listOf(),
                scope = CoroutineScope(dispatchers.io + SupervisorJob())
            )
        )
    }
}
