package com.nikolaenko.playground.feed.domain.model

data class FeedPage(
    val page: List<Post>,
    val nextKey: String?,
    val prevKey: String?
)