package com.nikolaenko.core.data.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.map

class ThemeDataStoreImpl(
    private val dataStore: DataStore<ThemeProto.ThemeData>
) : com.nikolaenko.core.domain.datastore.ThemeDataStore {

    override val flow = dataStore.data.map {
        com.nikolaenko.core.domain.model.Theme(isDark = it.isDark)
    }

    override suspend fun update(theme: com.nikolaenko.core.domain.model.Theme) {
        dataStore.updateData {
            it.toBuilder()
                .setIsDark(theme.isDark)
                .build()
        }
    }
}