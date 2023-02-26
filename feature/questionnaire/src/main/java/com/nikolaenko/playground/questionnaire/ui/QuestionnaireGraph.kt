package com.nikolaenko.playground.questionnaire.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.playground.questionnaire.ui.progress.Progress
import com.nikolaenko.playground.questionnaire.ui.questions.Questions
import com.nikolaenko.playground.questionnaire.ui.welcome.Welcome

@Suppress("FunctionName")
fun NavGraphBuilder.QuestionnaireGraph(
    navController: NavHostController,
    route: String
) {
    navigation(startDestination = Screen.Welcome.route, route = route) {
        composable(Screen.Welcome.route) {
            Welcome(
                onStart = {
                    navController.navigate(Screen.Questions.route)
                }
            )
        }
        composable(Screen.Questions.route) {
            Questions(
                onClose = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Progress.route) {
            Progress()
        }
    }
}

internal sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Progress : Screen("progress")
    object Questions : Screen("questions")
}