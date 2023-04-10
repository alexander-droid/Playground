package com.nikolaenko.playground.core.domain.datastore

import com.nikolaenko.playground.core.domain.model.UserSession
import kotlinx.coroutines.flow.Flow

interface UserSessionRepository {
    suspend fun update(userSession: UserSession)

    val flow: Flow<UserSession>
}