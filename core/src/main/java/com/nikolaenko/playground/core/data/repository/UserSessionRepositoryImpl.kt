package com.nikolaenko.playground.core.data.repository

import UserSessionProto
import androidx.datastore.core.DataStore
import com.nikolaenko.playground.core.domain.datastore.UserSessionRepository
import com.nikolaenko.playground.core.domain.model.UserSession
import kotlinx.coroutines.flow.map

class UserSessionRepositoryImpl(
    private val dataStore: DataStore<UserSessionProto.SessionData>
): UserSessionRepository {

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