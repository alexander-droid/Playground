package com.nikolaenko.playground.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.nikolaenko.playground.core.ui.attr.*

private val DarkColorPalette = darkColors(
    primary = DarkColors.primary,
    primaryVariant = DarkColors.primaryVariant,
    secondary = DarkColors.secondary,
    onPrimary = DarkColors.onPrimary,
    background = DarkColors.background,
    onBackground = DarkColors.onBackground,
    surface = DarkColors.surface,
    onSurface = DarkColors.onSurface
)

private val LightColorPalette = lightColors(
    primary = LightColors.primary,
    primaryVariant = LightColors.primaryVariant,
    secondary = LightColors.secondary,
    onPrimary = LightColors.onPrimary,
    background = LightColors.background,
    onBackground = LightColors.onBackground,
    surface = LightColors.surface,
    onSurface = LightColors.onSurface
)

@Composable
fun PlaygroundTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(
        LocalPaddings provides Paddings(),
        LocalElevations provides Elevations(card = 8.dp)
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object PlaygroundTheme {

    val colors: Colors
        @Composable
        get() = MaterialTheme.colors

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    val paddings: Paddings
        @Composable
        get() = LocalPaddings.current

    val elevations: Elevations
        @Composable
        get() = LocalElevations.current
}
