package com.nikolaenko.playground.ui.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolaenko.playground.R
import com.nikolaenko.playground.chat.ui.ChatGraph
import com.nikolaenko.playground.feed.ui.FeedGraph
import com.nikolaenko.playground.profile.ui.ProfileGraph
import com.nikolaenko.playground.questionnaire.ui.QuestionnaireGraph
import kotlinx.coroutines.launch

@Composable
fun Main(onThemeChanged: () -> Unit) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val items by remember {
        mutableStateOf(drawerItems)
    }
    var selectedItem by remember { mutableStateOf(drawerItems[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(14.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(stringResource(item.label)) },
                        selected = item == selectedItem,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem = item
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 2.dp
                        )
                    )
                }
            }
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = Screen.Tabs.route
            ) {
                composable(route = Screen.Tabs.route) { Tabs() }
                ProfileGraph(navController = navController, route = Screen.Profile.route)
                ChatGraph(navController = navController, route = Screen.Chat.route)
                FeedGraph(navController = navController, route = Screen.Feed.route)
                QuestionnaireGraph(navController = navController, route = Screen.Questionnaire.route)
            }
        }
    )

    BackHandler(drawerState.isOpen) {
        scope.launch {
            drawerState.close()
        }
    }
}

private data class DrawerItem(
    val label: Int,
    val screen: Screen
)

private val drawerItems = listOf(
    DrawerItem(screen = Screen.Tabs, label = R.string.title_home),
    DrawerItem(screen = Screen.Profile, label = R.string.title_profile),
    DrawerItem(screen = Screen.Chat, label = R.string.title_chat),
    DrawerItem(screen = Screen.Feed, label = R.string.title_feed),
    DrawerItem(screen = Screen.Questionnaire, label = R.string.title_questionnaire),
)

sealed class Screen(val route: String) {
    object Tabs : Screen("tabs")
    object Profile : Screen("profile_graph")
    object Chat : Screen("chat_graph")
    object Feed : Screen("feed_graph")
    object Questionnaire : Screen("questionnaire_graph")
}