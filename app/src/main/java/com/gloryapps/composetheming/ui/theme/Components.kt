package com.gloryapps.composetheming.ui.theme

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//region Buttons
@Composable
fun H19Button(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = H19Theme.shapes.small,
    backgroundColor: Color = H19Theme.colors.primary,
    contentColor: Color = Color.White,
    elevation: ButtonElevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = backgroundColor.copy(alpha = 0.20f),
        disabledContentColor = contentColor
    ),
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        elevation = elevation,
        colors = colors
    ) {
        ProvideTextStyle(value = H19Theme.typography.captionBold) {
            Text(text = text, color = contentColor)
        }
    }
}

@Composable
fun H19WrongButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: ButtonElevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        elevation = elevation,
    ) {
        Text(text = text)
    }
}

@Preview(
    name = "Button Light",
    group = "Correct Button",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Button Dark",
    group = "Correct Button",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun ButtonPreview() {
    H19Button(text = "Hello H19") {}
}

@Preview(
    name = "Wrong Button Light",
    group = "Wrong Button",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Wrong Button Dark",
    group = "Wrong Button",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun WrongButtonPreview() {
    H19WrongButton(text = "Hello H19") {}
}
//endregion

//region Surface
@Composable
fun H19Surface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = H19Theme.colors.background,
    contentColor: Color = defaultContentColorFor(color),
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        color = color,
        contentColor = contentColor,
        shape = shape,
        content = content
    )
}

@Preview(
    name = "Surface Light",
    group = "Surface",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Surface Dark",
    group = "Surface",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun SurfacePreview() {
    H19Theme {
        H19Surface {
            Text(text = "Surface Preview")
        }
    }
}
//endregion

