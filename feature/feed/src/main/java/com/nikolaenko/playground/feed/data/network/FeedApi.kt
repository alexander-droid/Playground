package com.nikolaenko.playground.feed.data.network

import com.nikolaenko.playground.feed.data.model.response.ResponseFeed
import com.nikolaenko.playground.feed.data.model.response.base.BaseResponse
import retrofit2.http.GET

interface FeedApi {

    @GET("api/v1/feed")
    suspend fun feed(): BaseResponse<ResponseFeed>
}