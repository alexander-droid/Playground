package com.nikolaenko.core.domain.datastore

import com.nikolaenko.core.domain.model.UserSession
import kotlinx.coroutines.flow.Flow

interface UserSessionDataStore {
    suspend fun update(userSession: UserSession)

    val flow: Flow<UserSession>
}