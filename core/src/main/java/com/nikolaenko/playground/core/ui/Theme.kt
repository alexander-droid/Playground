package com.nikolaenko.playground.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.nikolaenko.playground.core.ui.attr.DarkColorExtendedPalette
import com.nikolaenko.playground.core.ui.attr.DarkColorMaterialPalette
import com.nikolaenko.playground.core.ui.attr.Elevations
import com.nikolaenko.playground.core.ui.attr.ExtendedColors
import com.nikolaenko.playground.core.ui.attr.LightColorExtendedPalette
import com.nikolaenko.playground.core.ui.attr.LightColorMaterialPalette
import com.nikolaenko.playground.core.ui.attr.LocalColors
import com.nikolaenko.playground.core.ui.attr.LocalElevations
import com.nikolaenko.playground.core.ui.attr.LocalPaddings
import com.nikolaenko.playground.core.ui.attr.Paddings
import com.nikolaenko.playground.core.ui.attr.Shapes
import com.nikolaenko.playground.core.ui.attr.Typography

@Composable
fun PlaygroundTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val materialColors = if (darkTheme) {
        DarkColorMaterialPalette
    } else {
        LightColorMaterialPalette
    }
    val extendedColors = if (darkTheme) {
        DarkColorExtendedPalette
    } else {
        LightColorExtendedPalette
    }
    CompositionLocalProvider(
        LocalPaddings provides Paddings(),
        LocalElevations provides Elevations(card = 8.dp),
        LocalColors provides extendedColors
    ) {
        MaterialTheme(
            colorScheme = materialColors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object PlaygroundTheme {

    val materialColors: ColorScheme
        @Composable
        get() = MaterialTheme.colorScheme

    val extendedColors: ExtendedColors
        @Composable
        get() = LocalColors.current

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
