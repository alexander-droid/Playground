package com.nikolaenko.playground.core.ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.nikolaenko.playground.core.ui.PlaygroundTheme

private fun Modifier.applySelectable(isSelected: Boolean, onClick: () -> Unit) = composed {
    val color = if (isSelected) {
        PlaygroundTheme.materialColors.primary
    } else {
        PlaygroundTheme.extendedColors.unselected
    }
    val shape = remember { RoundedCornerShape(16.dp) }
    return@composed padding(
        horizontal = PlaygroundTheme.paddings.default,
        vertical = PlaygroundTheme.paddings.small
    )
        .border(
            border = BorderStroke(1.dp, color),
            shape = shape
        )
        .clip(shape)
        .clickable(onClick = onClick)
        .padding(
            start = PlaygroundTheme.paddings.default,
            end = PlaygroundTheme.paddings.small,
            top = PlaygroundTheme.paddings.small,
            bottom = PlaygroundTheme.paddings.small,
        )
}

@Composable
fun SingleSelectItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .applySelectable(isSelected, onClick)
    ) {
        Text(
            text = text,
            modifier = Modifier.weight(1f)
        )
        RadioButton(
            modifier = Modifier,
            selected = isSelected,
            onClick = onClick
        )
    }
}

@Composable
fun MultiSelectItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .applySelectable(isSelected, onClick)
    ) {
        Text(
            text = text,
            modifier = Modifier.weight(1f)
        )
        Checkbox(
            modifier = Modifier,
            checked = isSelected,
            onCheckedChange = { onClick() }
        )
    }
}