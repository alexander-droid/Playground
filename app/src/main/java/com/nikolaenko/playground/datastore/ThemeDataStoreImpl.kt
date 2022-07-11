package com.nikolaenko.playground.datastore

import androidx.datastore.core.DataStore
import com.nikolaenko.playground.domain.datastore.ThemeDataStore
import com.nikolaenko.playground.domain.model.Theme
import kotlinx.coroutines.flow.map

class ThemeDataStoreImpl(
    private val dataStore: DataStore<ThemeProto.ThemeData>
) : ThemeDataStore {

    override val flow = dataStore.data.map {
        Theme(isDark = it.isDark)
    }

    override suspend fun update(theme: Theme) {
        dataStore.updateData {
            it.toBuilder()
                .setIsDark(theme.isDark)
                .build()
        }
    }
}