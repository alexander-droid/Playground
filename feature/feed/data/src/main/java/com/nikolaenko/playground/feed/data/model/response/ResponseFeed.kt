package com.nikolaenko.playground.feed.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseFeed(
    @Json(name = "feed")
    val feed: List<Post>,

    @Json(name = "prevKey")
    val prevKey: String?,

    @Json(name = "nextKey")
    val nextKey: String?
) {

    @JsonClass(generateAdapter = true)
    data class Post(

        @Json(name = "id")
        val id: String?,

        @Json(name = "title")
        val title: String?,

        @Json(name = "body")
        val body: String?,

        @Json(name = "image")
        val image: String?,

        @Json(name = "likeCount")
        val likeCount: Int?,

        @Json(name = "isLiked")
        val isLiked: Boolean?
    )
}