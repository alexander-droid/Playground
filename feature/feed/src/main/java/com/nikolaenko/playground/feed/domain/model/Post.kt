package com.nikolaenko.playground.feed.domain.model

data class Post(
    val id: String,
    val title: String,
    val body: String,
    val image: String?,
    val likeCount: Int,
    val isLiked: Boolean
)