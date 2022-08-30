package com.nikolaenko.playground.core.data.datastore

import androidx.datastore.core.DataStore
import com.nikolaenko.playground.core.domain.datastore.UserSessionDataStore
import com.nikolaenko.playground.core.domain.model.UserSession
import kotlinx.coroutines.flow.map

class UserSessionDataStoreImpl(
    private val dataStore: DataStore<UserSessionProto.SessionData>
): UserSessionDataStore {

    override val flow = dataStore.data.map {
        UserSession(isLoggedIn = it.isLoggedIn)
    }

    override suspend fun update(userSession: UserSession) {
        dataStore.updateData {
            it.toBuilder()
                .setIsLoggedIn(userSession.isLoggedIn)
                .build()
        }
    }
}