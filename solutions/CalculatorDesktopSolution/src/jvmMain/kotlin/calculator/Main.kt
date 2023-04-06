package calculator

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
        title = "Solution To The Calculator Exercise",
        state = rememberWindowState(
            size = DpSize(350.dp, 400.dp)
        )
    ) {
        CalculatorApp()
    }
}
