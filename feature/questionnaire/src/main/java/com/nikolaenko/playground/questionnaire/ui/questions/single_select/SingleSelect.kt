package com.nikolaenko.playground.questionnaire.ui.questions.single_select

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikolaenko.playground.core.ui.PlaygroundTheme
import com.nikolaenko.playground.core.ui.ext.fadingBottom
import com.nikolaenko.playground.core.ui.widget.SingleSelectItem
import com.nikolaenko.playground.questionnaire.R

@Composable
internal fun SingleSelect() {

    val viewModel = hiltViewModel<SingleSelectViewModel>()
    val state by viewModel.state.collectAsState()

    val listState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shadowElevation = if (listState.canScrollBackward) PlaygroundTheme.elevations.scrollTop else 0.dp
        ) {
            Text(
                modifier = Modifier.padding(PlaygroundTheme.paddings.default),
                text = stringResource(id = R.string.title_single_select),
                style = PlaygroundTheme.typography.headlineLarge
            )
        }
        LazyColumn(
            modifier = Modifier.weight(1f).fadingBottom(),
            contentPadding = PaddingValues(
                top = PlaygroundTheme.paddings.small,
                bottom = PlaygroundTheme.paddings.small
            ),
            state = listState
        ) {
            items(state.list.size) {
                Item(state.list[it])
            }
        }
    }
}

@Composable
private fun Item(item: SingleSelectViewModel.State.Item) {
    val viewModel = hiltViewModel<SingleSelectViewModel>()

    SingleSelectItem(text = item.name, isSelected = item.isSelected) {
        viewModel.select(item)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SingleSelectPreview() {
    PlaygroundTheme {
        SingleSelect()
    }
}