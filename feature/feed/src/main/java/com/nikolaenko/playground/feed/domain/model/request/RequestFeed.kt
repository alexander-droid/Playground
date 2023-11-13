package com.nikolaenko.playground.feed.domain.model.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestFeed(
    @Json(name = "nextId")
    val nextId: String?,
    @Json(name = "pageSize")
    val pageSize: Int
)