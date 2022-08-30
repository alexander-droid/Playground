package com.nikolaenko.playground.core.domain.datastore

import com.nikolaenko.playground.core.domain.model.Theme
import kotlinx.coroutines.flow.Flow

interface ThemeDataStore {
    suspend fun update(theme: Theme)

    val flow: Flow<Theme>
}