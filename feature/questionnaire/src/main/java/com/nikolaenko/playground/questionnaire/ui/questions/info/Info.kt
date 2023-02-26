package com.nikolaenko.playground.questionnaire.ui.questions.info

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikolaenko.playground.core.ui.PlaygroundTheme
import com.nikolaenko.playground.core.ui.ext.fadingBottom
import com.nikolaenko.playground.questionnaire.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Info() {
    val viewModel = hiltViewModel<InfoViewModel>()
    val state by viewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .fadingBottom()
            .padding(vertical = PlaygroundTheme.paddings.large, horizontal = PlaygroundTheme.paddings.default),
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.firstName,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words,
                autoCorrect = false
            ),
            label = {
                Text(text = stringResource(id = R.string.hint_first_name))
            },
            onValueChange = viewModel::setFirstName
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.lastName,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words,
                autoCorrect = false
            ),
            label = {
                Text(text = stringResource(id = R.string.hint_last_name))
            },
            onValueChange = viewModel::setLastName
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.middleName,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words,
                autoCorrect = false
            ),
            label = {
                Text(text = stringResource(id = R.string.hint_middle_name))
            },
            onValueChange = viewModel::setLastName
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun InfoPreview() {
    PlaygroundTheme {
        Info()
    }
}