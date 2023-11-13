package com.nikolaenko.playground.feed.domain.network

import com.nikolaenko.playground.feed.domain.model.response.ResponseFeed
import com.nikolaenko.playground.core.domain.model.BaseResponse
import com.nikolaenko.playground.feed.domain.model.request.RequestFeed
import retrofit2.http.Body
import retrofit2.http.GET

interface FeedApi {

    @GET("api/v1/feed")
    suspend fun feed(
        @Body body: RequestFeed
    ): BaseResponse<ResponseFeed>
}