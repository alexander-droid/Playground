package com.nikolaenko.playground.questionnaire.ui.questions

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.nikolaenko.playground.core.ui.PlaygroundTheme
import com.nikolaenko.playground.questionnaire.R
import com.nikolaenko.playground.questionnaire.ui.questions.confirm.Confirm
import com.nikolaenko.playground.questionnaire.ui.questions.info.Info
import com.nikolaenko.playground.questionnaire.ui.questions.multi_select.MultiSelect
import com.nikolaenko.playground.questionnaire.ui.questions.single_select.SingleSelect

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
internal fun Questions(onClose: () -> Unit) {
    val viewModel = hiltViewModel<QuestionsViewModel>()
    val navController = rememberAnimatedNavController()
    val state by viewModel.state.collectAsState()

    val exit by viewModel.exit.collectAsState(initial = null)
    if (exit != null) {
        LaunchedEffect(exit) {
            onClose()
        }
    }

    val navigate = viewModel.navigate.collectAsState(initial = null).value
    if (navigate != null) {
        LaunchedEffect(navigate) {
            when(navigate) {
                is QuestionsViewModel.Nav.Back -> navController.navigateUp()
                is QuestionsViewModel.Nav.Forward -> {
                    //TODO ArrayIndexOutOfBoundsException: length=4; index=4
                    navController.navigate(state.questions[navigate.index].route) {
                        launchSingleTop = true
                    }
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .imePadding()
            .navigationBarsPadding(),
    ) {
        Header(
            onClose = onClose,
            viewModel = viewModel,
            navController = navController,
        )
        Content(
            viewModel = viewModel,
            navController = navController
        )
        Footer(
            viewModel = viewModel,
            navController = navController
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun ColumnScope.Content(
    viewModel: QuestionsViewModel,
    navController: NavHostController
) {
    val state by viewModel.state.collectAsState()
    Box(modifier = Modifier.fillMaxWidth().weight(1f)) {
        AnimatedNavHost(
            navController = navController,
            startDestination = QuestionScreen.SingleSelect.route,
            enterTransition = {
                slideInHorizontally { it }
            },
            exitTransition = {
                slideOutHorizontally { -it }
            },
            popEnterTransition = {
                slideInHorizontally { -it }
            },
            popExitTransition = {
                slideOutHorizontally { it }
            }
        ) {
            state.questions.forEach { screen ->
                composable(screen.route) {
                    BackHandler(true, viewModel::onPrevQuestion)
                    when (screen) {
                        QuestionScreen.SingleSelect -> SingleSelect()
                        QuestionScreen.MultiSelect -> MultiSelect()
                        QuestionScreen.Info -> Info()
                        QuestionScreen.Confirm -> Confirm()
                    }
                }
            }
        }
    }
}

@Composable
private fun Header(
    onClose: () -> Unit,
    viewModel: QuestionsViewModel,
    navController: NavHostController,
) {
    val state by viewModel.state.collectAsState()
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(
                    id = R.string.current_of_all,
                    formatArgs = arrayOf(state.currentScreenIndex + 1, state.screenCount)
                )
            )
            IconButton(
                onClick = onClose,
                modifier = Modifier.align(Alignment.CenterEnd),
            ) {
                Icon(
                    imageVector = Icons.Filled.Close, contentDescription = stringResource(R.string.close)
                )
            }
        }

        val progressValue = (state.currentScreenIndex + 1f) / state.screenCount
        val infiniteTransition by animateFloatAsState(targetValue = progressValue)
        LinearProgressIndicator(
            progress = infiniteTransition,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = PlaygroundTheme.paddings.default)
        )
    }
}

@Composable
private fun Footer(
    navController: NavHostController,
    viewModel: QuestionsViewModel
) {
    val state by viewModel.state.collectAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = PlaygroundTheme.paddings.small,
                horizontal = PlaygroundTheme.paddings.default,
            )
    ) {
        Button(
            onClick = viewModel::onPrevQuestion,
            enabled = state.canGoPrev,
            modifier = Modifier
                .weight(1f)
                .padding(end = PlaygroundTheme.paddings.small),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp//TODO
            )
        ) {
            Text(text = stringResource(id = R.string.previous))
        }
        Button(
            onClick = viewModel::onNextQuestion,
            enabled = state.canGoNext,
            modifier = Modifier
                .weight(1f)
                .padding(start = PlaygroundTheme.paddings.small),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp//TODO
            )
        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}

internal sealed class QuestionScreen(val route: String) {
    object SingleSelect : QuestionScreen("single_select")
    object MultiSelect : QuestionScreen("multi_select")
    object Info : QuestionScreen("info")
    object Confirm : QuestionScreen("confirm")
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun QuestionsPreview() {
    PlaygroundTheme {
        Questions {}
    }
}
