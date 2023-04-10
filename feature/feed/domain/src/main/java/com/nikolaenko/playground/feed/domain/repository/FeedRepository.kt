package com.nikolaenko.playground.feed.domain.repository

import com.nikolaenko.playground.feed.domain.model.FeedPage
import com.nikolaenko.playground.feed.domain.model.action.ActionGetFeed

interface FeedRepository {
    suspend fun feed(action: ActionGetFeed): FeedPage
}