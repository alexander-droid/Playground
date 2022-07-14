package com.nikolaenko.settings.domain.datastore

import com.nikolaenko.settings.domain.model.Theme
import kotlinx.coroutines.flow.Flow

interface ThemeDataStore {
    suspend fun update(theme: Theme)

    val flow: Flow<Theme>
}