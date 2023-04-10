package com.nikolaenko.playground.feed.data.datasource

import com.nikolaenko.playground.core.data.datasource.PagingDataSource
import com.nikolaenko.playground.core.domain.model.Page
import com.nikolaenko.playground.feed.domain.model.Post
import com.nikolaenko.playground.feed.domain.model.action.ActionGetFeed
import com.nikolaenko.playground.feed.domain.repository.FeedRepository

class FeedDataSource(
    private val repository: FeedRepository
): com.nikolaenko.playground.core.data.datasource.PagingDataSource<Post>() {

    override fun getKey(item: Post): String {
        return item.id
    }

    override suspend fun load(id: String?, size: Int): com.nikolaenko.playground.core.domain.model.Page<Post> {
        val resp = repository.feed(ActionGetFeed(id, size))
        return com.nikolaenko.playground.core.domain.model.Page(
            list = resp.page,
            prevKey = resp.prevKey,
            nextKey = resp.nextKey
        )
    }
}