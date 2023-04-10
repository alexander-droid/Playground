package com.nikolaenko.playground.core.domain.model

data class Page<D>(
    val list: List<D>,
    val prevKey: String?,
    val nextKey: String?
)