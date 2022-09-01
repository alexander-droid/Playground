package com.nikolaenko.playground.ui.main

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.nikolaenko.playground.R
import com.nikolaenko.playground.chat.ui.ChatGraph
import com.nikolaenko.playground.feed.ui.FeedGraph

@Composable
fun Tabs() {
    val screens = listOf(TabScreen.Feed, TabScreen.Chat)
    val navController = rememberNavController()
    ConstraintLayout {
        val (containerRef, bottomRef) = createRefs()
        Column(
            modifier = Modifier
                .constrainAs(containerRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomRef.top)
                },
        ) {
            NavHost(
                navController = navController,
                startDestination = TabScreen.Feed.route
            ) {
                FeedGraph(
                    navController = navController,
                    route = TabScreen.Feed.route
                )
                ChatGraph(
                    navController = navController,
                    route = TabScreen.Chat.route
                )
            }
        }
        Column(
            modifier = Modifier
                .constrainAs(bottomRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            BottomBar(navController, screens)
        }
    }
}

sealed class TabScreen(val route: String, val image: ImageVector, @StringRes val titleId: Int) {
    object Feed : TabScreen("feed_graph", Icons.Filled.List, R.string.bottom_tab_feed)
    object Chat : TabScreen("chat_graph", Icons.Filled.Chat, R.string.bottom_tab_chat)
}