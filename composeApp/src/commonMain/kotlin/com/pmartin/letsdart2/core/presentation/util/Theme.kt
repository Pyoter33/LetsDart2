package com.pmartin.letsdart2.core.presentation.util

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightThemeColors = lightColors(
    primary = PrimaryColor,
    secondary = SecondaryColor,
    onPrimary = PrimaryTextColor,
    onSecondary = SecondaryTextColor,
    background = BackgroundColor,
    onBackground = PrimaryColor
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(colors = LightThemeColors, typography = AppTypography()) {
        content()
    }
}