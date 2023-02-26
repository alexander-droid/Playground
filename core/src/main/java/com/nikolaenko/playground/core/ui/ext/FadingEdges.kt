package com.nikolaenko.playground.core.ui.ext

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nikolaenko.playground.core.ui.PlaygroundTheme

fun Modifier.fadingBottom() = composed {
    val colors = listOf(
        Color.Transparent,
        PlaygroundTheme.materialColors.surface
    )
    return@composed drawWithContent {
        drawContent()
        drawRect(
            brush = Brush.verticalGradient(
                colors = colors,
                startY = size.height - 16.dp.toPx(),
                endY = size.height
            ),
        )
    }
}

fun Modifier.fadingTop() = composed {
    val colors = listOf(
        Color.Transparent,
        PlaygroundTheme.materialColors.surface
    )
    return@composed drawWithContent {
        drawRect(
            brush = Brush.verticalGradient(
                colors = colors,
                startY = 0f,
                endY = 16.dp.toPx()
            ),
        )
        drawContent()
    }
}