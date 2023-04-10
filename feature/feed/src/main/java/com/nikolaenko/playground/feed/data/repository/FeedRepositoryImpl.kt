package com.nikolaenko.playground.feed.data.repository

import com.nikolaenko.playground.feed.data.model.response.ResponseFeed
import com.nikolaenko.playground.feed.data.model.response.base.BaseResponse
import com.nikolaenko.playground.feed.data.network.FeedApi
import com.nikolaenko.playground.feed.domain.model.FeedPage
import com.nikolaenko.playground.feed.domain.model.Post
import com.nikolaenko.playground.feed.domain.model.action.ActionGetFeed
import com.nikolaenko.playground.feed.domain.repository.FeedRepository

class FeedRepositoryImpl(
    private val api: FeedApi
) : FeedRepository {

    override suspend fun feed(action: ActionGetFeed): FeedPage {
        return api.feed().toDomain()
    }
}

private fun BaseResponse<ResponseFeed>.toDomain(): FeedPage {
    return FeedPage(
        page = data?.feed?.map {
            Post(
                id = it.id.orEmpty(),
                title = it.title.orEmpty(),
                body = it.body.orEmpty(),
                image = it.image,
                likeCount = it.likeCount ?: 0,
                isLiked = it.isLiked ?: false,
            )
        }.orEmpty(),
        prevKey = data?.prevKey,
        nextKey = data?.nextKey
    )
}