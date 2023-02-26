package com.nikolaenko.playground.core.ui.attr

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Elevations(
    val card: Dp = 8.dp,
    val scrollTop: Dp = 2.dp,
    val scrollBottom: Dp = 8.dp
)

val LocalElevations = staticCompositionLocalOf { Elevations() }
