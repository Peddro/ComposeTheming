package com.gloryapps.composetheming.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.LocalContentColor
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Shapes
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

val LightColors = H19Colors(
    primary = Blue,
    background = Color.White,
    textPrimary = Color.White,
    onPrimary = Color.White,
    onBackground = DarkGrey,
    isLight = true
)

val DarkColors = H19Colors(
    primary = Blue,
    background = DarkGrey,
    textPrimary = Color.White,
    onPrimary = Color.White,
    onBackground = Color.White,
    isLight = false
)

@Composable
fun H19Theme(
    typography: H19Typography = H19Theme.typography,
    shapes: Shapes = H19Theme.shapes,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    val rippleIndication = rememberRipple()

    // creating a new object for colors to not mutate the initial colors set when updating the values
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalShapes provides shapes,
        LocalTypography provides typography,
        LocalIndication provides rippleIndication,
        LocalRippleTheme provides MaterialRippleTheme,
    ) {
        ProvideTextStyle(value = typography.body1, content = content)
    }
}

object H19Theme {

    val colors: H19Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: H19Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    // We use the default material shapes
    val shapes: Shapes
        @ReadOnlyComposable
        @Composable
        get() = LocalShapes.current
}

@Immutable
private object MaterialRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = LocalContentColor.current,
        lightTheme = H19Theme.colors.isLight
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = LocalContentColor.current,
        lightTheme = H19Theme.colors.isLight
    )
}