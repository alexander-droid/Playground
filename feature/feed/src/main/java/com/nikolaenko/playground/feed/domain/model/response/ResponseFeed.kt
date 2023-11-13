package com.nikolaenko.playground.feed.domain.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseFeed(
    @Json(name = "prevKey")
    val prevKey: String?,

    @Json(name = "nextKey")
    val nextKey: String?,

    @Json(name = "feed")
    val feed: List<Post>
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