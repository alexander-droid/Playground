package com.nikolaenko.core.domain.datastore

import com.nikolaenko.core.domain.model.Theme
import kotlinx.coroutines.flow.Flow

interface ThemeDataStore {
    suspend fun update(theme: Theme)

    val flow: Flow<Theme>
}