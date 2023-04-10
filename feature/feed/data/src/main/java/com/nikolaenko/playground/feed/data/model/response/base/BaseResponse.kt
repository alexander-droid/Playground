package com.nikolaenko.playground.feed.data.model.response.base

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponse<D>(
    @Json(name = "data")
    val data: D?,
    @Json(name = "error")
    val error: Error?
) {

    @JsonClass(generateAdapter = true)
    data class Error(
        @Json(name = "message")
        val message: String?
    )
}