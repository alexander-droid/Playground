package com.nikolaenko.playground.domain.datastore

import com.nikolaenko.playground.domain.model.Theme
import kotlinx.coroutines.flow.Flow

interface ThemeDataStore {
    suspend fun update(theme: Theme)

    val flow: Flow<Theme>
}