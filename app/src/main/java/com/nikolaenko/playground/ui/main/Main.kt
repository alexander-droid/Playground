package com.nikolaenko.playground.ui.main

import androidx.activity.compose.BackHandler
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolaenko.playground.chat.ui.ChatGraph
import com.nikolaenko.playground.feed.ui.FeedGraph
import com.nikolaenko.playground.profile.ui.ProfileGraph
import com.nikolaenko.playground.questionnaire.ui.QuestionnaireGraph
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Main(onThemeChanged: () -> Unit) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                onThemeChanged = onThemeChanged,
                goToProfile = {
                    goTo(Screen.Profile, navController, scope, drawerState)
                },
                goToChat = {
                    goTo(Screen.Chat, navController, scope, drawerState)
                },
                goToFeed = {
                    goTo(Screen.Feed, navController, scope, drawerState)
                },
                goToQuestionnaire = {
                    goTo(Screen.Questionnaire, navController, scope, drawerState)
                }
            )
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

private fun goTo(profile: Screen, navController: NavHostController, scope: CoroutineScope, drawerState: DrawerState) {
    scope.launch { drawerState.close() }
    navController.navigate(profile.route) {
        popUpTo(navController.graph.startDestinationId)
        launchSingleTop = true
    }
}

sealed class Screen(val route: String) {
    object Tabs : Screen("tabs")
    object Profile : Screen("profile_graph")
    object Chat : Screen("chat_graph")
    object Feed : Screen("feed_graph")
    object Questionnaire : Screen("questionnaire_graph")
}