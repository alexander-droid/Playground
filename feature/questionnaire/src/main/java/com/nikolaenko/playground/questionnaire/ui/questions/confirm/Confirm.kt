package com.nikolaenko.playground.questionnaire.ui.questions.confirm

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import com.nikolaenko.playground.core.ui.PlaygroundTheme
import com.nikolaenko.playground.core.ui.ext.fadingBottom
import com.nikolaenko.playground.questionnaire.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Confirm() {
    Box(modifier = Modifier.fillMaxSize().fadingBottom()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = PlaygroundTheme.paddings.xlarge, horizontal = PlaygroundTheme.paddings.default)
        ) {
            Text(text = stringResource(id = R.string.title_confirm))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                label = {
                    Text(text = stringResource(id = R.string.hint_first_name))
                },
                onValueChange = {  }
            )

        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ConfirmPreview() {
    PlaygroundTheme {
        Confirm()
    }
}