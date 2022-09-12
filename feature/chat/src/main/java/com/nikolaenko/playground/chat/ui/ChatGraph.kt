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
        composable(route = Screen.Contacts.route) {
            Contacts(
                goToMessages = {
                    navController.navigate(Screen.Messages.route)
                }
            )
        }
        composable(Screen.Messages.route) {
            Messages()
        }
    }
}

internal sealed class Screen(val route: String) {
    object Contacts : Screen("contacts")
    object Messages : Screen("chat")
}