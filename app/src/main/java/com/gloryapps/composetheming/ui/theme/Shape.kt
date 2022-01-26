package com.gloryapps.composetheming.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

internal val LocalShapes = staticCompositionLocalOf {
    Shapes(
        small = RoundedCornerShape(size = 15.dp),
        medium = RoundedCornerShape(size = 20.dp),
        large = RoundedCornerShape(size = 20.dp)
    )
}
