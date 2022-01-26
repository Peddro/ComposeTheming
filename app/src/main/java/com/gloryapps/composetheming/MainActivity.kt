package com.gloryapps.composetheming

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gloryapps.composetheming.ui.theme.H19Button
import com.gloryapps.composetheming.ui.theme.H19Surface
import com.gloryapps.composetheming.ui.theme.H19Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            H19Theme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    H19Surface {
        H19Button(text = "Hello $name!") {}
    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    H19Theme {
        Greeting(name = "Android")
    }
}