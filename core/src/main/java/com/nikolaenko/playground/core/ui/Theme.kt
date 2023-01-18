package com.nikolaenko.playground.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.nikolaenko.playground.core.ui.attr.DarkColors
import com.nikolaenko.playground.core.ui.attr.Elevations
import com.nikolaenko.playground.core.ui.attr.LightColors
import com.nikolaenko.playground.core.ui.attr.LocalElevations
import com.nikolaenko.playground.core.ui.attr.LocalPaddings
import com.nikolaenko.playground.core.ui.attr.Paddings
import com.nikolaenko.playground.core.ui.attr.Shapes
import com.nikolaenko.playground.core.ui.attr.Typography

private val DarkColorPalette = darkColorScheme(
    primary = DarkColors.primary,
    onPrimary = DarkColors.onPrimary,
    secondary = DarkColors.secondary,
    onSecondary = DarkColors.onSecondary,
    background = DarkColors.background,
    onBackground = DarkColors.onBackground,
    surface = DarkColors.surface,
    onSurface = DarkColors.onSurface
)

private val LightColorPalette = lightColorScheme(
    primary = LightColors.primary,
    onPrimary = LightColors.onPrimary,
    secondary = LightColors.secondary,
    onSecondary = LightColors.onSecondary,
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
            colorScheme = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object PlaygroundTheme {

    val colors: ColorScheme
        @Composable
        get() = MaterialTheme.colorScheme

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
