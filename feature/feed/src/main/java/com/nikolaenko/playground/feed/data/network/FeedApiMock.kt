package com.nikolaenko.playground.feed.data.network

import com.nikolaenko.playground.core.domain.model.BaseResponse
import com.nikolaenko.playground.core.logger.Logger
import com.nikolaenko.playground.feed.domain.model.request.RequestFeed
import com.nikolaenko.playground.feed.domain.model.response.ResponseFeed
import com.nikolaenko.playground.feed.domain.network.FeedApi
import kotlinx.coroutines.delay

class FeedApiMock : FeedApi {

    private val feed by lazy {
        mutableListOf<ResponseFeed.Post>().apply {
            repeat(50) {
                add(
                    ResponseFeed.Post(
                        id = "$it",
                        title = "Post title $it",
                        body = "$it Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        image = "https://cq.ru/storage/uploads/posts/1564470/1.jpg",
                        likeCount = it,
                        isLiked = it % 2 == 0
                    )
                )
            }
        }
    }

    override suspend fun feed(body: RequestFeed): BaseResponse<ResponseFeed> {
        try {
            Logger.v("Get feed request $body")
            delay(2000)
            val response = if (body.nextId == null) {
                BaseResponse(
                    data = ResponseFeed(
                        feed = feed.subList(0, body.pageSize.coerceAtMost(feed.size)),
                        prevKey = null,
                        nextKey = feed.getOrNull(body.pageSize)?.id
                    ),
                    error = null
                )
            } else {
                val nextPageIndex = feed.indexOfLast { it.id == body.nextId }
                BaseResponse(
                    data = ResponseFeed(
                        feed = feed.subList(nextPageIndex, (nextPageIndex + body.pageSize).coerceAtMost(feed.size)),
                        prevKey = feed.getOrNull(nextPageIndex - body.pageSize)?.id,
                        nextKey = feed.getOrNull(nextPageIndex + body.pageSize)?.id
                    ),
                    error = null
                )
            }
            Logger.v("Get feed response ${response.data?.prevKey}, ${response.data?.nextKey}, ${response.data?.feed?.map { it.id }}")
            Logger.v("-----------------")
            return response
        } catch (exc: Exception) {
            Logger.e(exc)
            throw exc
        }
    }
}