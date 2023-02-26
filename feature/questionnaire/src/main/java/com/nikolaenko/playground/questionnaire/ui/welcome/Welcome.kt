package com.nikolaenko.playground.questionnaire.ui.welcome

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.nikolaenko.playground.core.ui.PlaygroundTheme
import com.nikolaenko.playground.questionnaire.R

@Composable
internal fun Welcome(onStart: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(PlaygroundTheme.paddings.large)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        val defaultPadding = PlaygroundTheme.paddings.default
        val (titleRef, descRef, buttonRef) = createRefs()
        Text(
            modifier = Modifier
                .constrainAs(titleRef) {
                    top.linkTo(parent.top)
                    linkTo(parent.start, parent.end)
                    width = Dimension.matchParent
                },
            text = stringResource(id = R.string.welcome_title),
            style = PlaygroundTheme.typography.headlineLarge
        )

        Text(
            modifier = Modifier
                .constrainAs(descRef) {
                    top.linkTo(titleRef.bottom, defaultPadding)
                    linkTo(parent.start, parent.end)
                    width = Dimension.matchParent
                },
            text = stringResource(id = R.string.welcome_description)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(buttonRef) {
                    linkTo(parent.start, parent.end)
                    linkTo(descRef.bottom, parent.bottom, bias = 1f)
                },
            onClick = onStart
        ) {
            Text(
                text = stringResource(id = R.string.welcome_start),
                style = PlaygroundTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
@Preview
fun WelcomePreview() {
    Surface {
        Welcome({})
    }
}