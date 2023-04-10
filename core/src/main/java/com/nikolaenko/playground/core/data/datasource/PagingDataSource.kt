package com.nikolaenko.playground.core.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nikolaenko.playground.core.domain.model.Page

abstract class PagingDataSource<D : Any> : PagingSource<String, D>() {

    override fun getRefreshKey(state: PagingState<String, D>): String? {
        val position = ((state.anchorPosition ?: 0) - state.config.initialLoadSize / 2).coerceAtLeast(0)
        val item = state.closestItemToPosition(position) ?: return null
        return getKey(item)
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, D> =
        try {
            val page = load(params.key, params.loadSize)
            LoadResult.Page(
                data = page.list,
                prevKey = page.prevKey,
                nextKey = page.nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    abstract suspend fun load(id: String?, size: Int): Page<D>

    abstract fun getKey(item: D): String
}