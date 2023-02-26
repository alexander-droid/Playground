package com.nikolaenko.playground.core.ui.attr

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtendedColors(
    val bottomContainer: Color,
    val unselected: Color,
)

internal val DarkColorExtendedPalette = ExtendedColors(
    bottomContainer = ExtendedDarkColorScheme.bottomContainer,
    unselected = ExtendedDarkColorScheme.unselected,
)

internal val LightColorExtendedPalette = ExtendedColors(
    bottomContainer = ExtendedLightColorScheme.bottomContainer,
    unselected = ExtendedLightColorScheme.unselected,
)

val LocalColors = staticCompositionLocalOf {
    DarkColorExtendedPalette
}