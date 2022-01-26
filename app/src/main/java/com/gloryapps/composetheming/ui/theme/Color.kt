package com.gloryapps.composetheming.ui.theme

import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse

val Blue = Color(0xFF3651F1)
val DarkGrey = Color(0xFF141F33)

class H19Colors(
    primary: Color,
    background: Color,
    textPrimary: Color,
    onPrimary: Color,
    onBackground: Color,
    isLight: Boolean
) {

    var primary by mutableStateOf(primary)
        private set
    var background by mutableStateOf(background)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var isLight by mutableStateOf(isLight)
        private set

    fun copy(
        primary: Color = this.primary,
        background: Color = this.background,
        textPrimary: Color = this.textPrimary,
        onPrimary: Color = this.onPrimary,
        onBackground: Color = this.onBackground,
        isLight: Boolean = this.isLight
    ): H19Colors = H19Colors(
        primary,
        background,
        textPrimary,
        onPrimary,
        onBackground,
        isLight
    )

    fun updateColorsFrom(other: H19Colors) {
        primary = other.primary
        background = other.background
        textPrimary = other.textPrimary
        onPrimary = other.onPrimary
        onBackground = other.onBackground
        isLight = other.isLight
    }
}

@Composable
@ReadOnlyComposable
fun defaultContentColorFor(backgroundColor: Color): Color =
    H19Theme.colors.contentColorFor(backgroundColor).takeOrElse { LocalContentColor.current }

private fun H19Colors.contentColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
        primary -> onPrimary
        background -> onBackground
        else -> Color.Unspecified
    }
}

internal val LocalColors = staticCompositionLocalOf { LightColors }
