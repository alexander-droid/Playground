package com.nikolaenko.playground.feed.ui.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.AsyncImage
import com.nikolaenko.playground.core.ui.PlaygroundTheme
import com.nikolaenko.playground.feed.domain.model.Post

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
internal fun FeedScreen(
    goToDetails: () -> Unit
) {

    val viewModel = hiltViewModel<FeedViewModel>()
    val state by viewModel.stateFlow.collectAsState()
    val feed = viewModel.feed.collectAsLazyPagingItems()
    val isRefreshing = feed.loadState.refresh == LoadState.Loading

    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = { feed.refresh() }
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        topBar = {
            Text(text = state?.title.orEmpty(), modifier = Modifier.height(100.dp))
        }
    ) { paddingValues ->
        paddingValues
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            when (feed.loadState.refresh) {
                LoadState.Loading -> {
                    //TODO implement loading state
                }
                is LoadState.Error -> {
                    //TODO implement error state
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .pullRefresh(pullRefreshState),
                        contentPadding = WindowInsets.navigationBars.asPaddingValues()
                    )
                    {
                        itemsIndexed(feed) { index, post ->
                            post?.also {
                                PostItem(
                                    post = post,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            goToDetails()
                                        }
                                        .padding(16.dp)
                                )
                            }
                        }
                    }
                }
            }
            PullRefreshIndicator(
                refreshing = isRefreshing,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}

@Composable
internal fun PostItem(post: Post, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = post.title)
        Text(text = post.body)
        AsyncImage(
            model = post.image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
private fun FeedPreview() {
    PlaygroundTheme {
        FeedScreen {

        }
    }
}