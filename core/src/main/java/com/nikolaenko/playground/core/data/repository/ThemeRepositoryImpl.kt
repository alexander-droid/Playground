package com.nikolaenko.playground.core.data.repository

import androidx.datastore.core.DataStore
import com.google.protobuf.BoolValue
import com.nikolaenko.playground.core.domain.datastore.ThemeRepository
import com.nikolaenko.playground.core.domain.model.Theme
import kotlinx.coroutines.flow.map

class ThemeRepositoryImpl(
    private val dataStore: DataStore<ThemeProto.ThemeData>
) : ThemeRepository {

    override val flow = dataStore.data.map {
        if (it.hasIsDark()) {
            Theme(isDark = it.isDark.value)
        } else {
            Theme(isDark = null)
        }
    }

    override suspend fun update(theme: Theme) {
        dataStore.updateData {
            val isDark = theme.isDark
            if (isDark == null) {
                it.toBuilder()
                    .clearIsDark()
                    .build()
            } else {
                it.toBuilder()
                    .setIsDark(BoolValue.of(isDark))
                    .build()
            }
        }
    }
}