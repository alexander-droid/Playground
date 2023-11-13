package com.nikolaenko.playground.feed.domain.repository

import com.nikolaenko.playground.feed.domain.model.FeedPage
import com.nikolaenko.playground.feed.domain.model.request.RequestFeed

interface FeedRepository {
    suspend fun feed(request: RequestFeed): FeedPage
}