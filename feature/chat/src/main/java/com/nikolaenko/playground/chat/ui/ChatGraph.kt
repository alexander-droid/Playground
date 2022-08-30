package com.nikolaenko.playground.chat.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.playground.chat.ui.contacts.Contacts
import com.nikolaenko.playground.chat.ui.messages.Messages

fun NavGraphBuilder.ChatGraph(
    navController: NavHostController,
    route: String
) {
    navigation(startDestination = Screen.Contacts.route, route) {
        composable(Screen.Messages.route) {
            Messages()
        }
        composable(route = Screen.Contacts.route) {
            Contacts()
        }
    }
}

sealed class Screen(val route: String) {
    object Messages : Screen("chat")
    object Contacts : Screen("contacts")
}