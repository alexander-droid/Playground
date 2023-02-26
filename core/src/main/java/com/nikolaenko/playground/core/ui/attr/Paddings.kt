package com.nikolaenko.playground.core.ui.attr

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Paddings(
    val default: Dp = 16.dp,
    val tiny: Dp = 4.dp,
    val small: Dp = 8.dp,
    val large: Dp = 24.dp,
    val xlarge: Dp = 28.dp
)

val LocalPaddings = staticCompositionLocalOf { Paddings() }
