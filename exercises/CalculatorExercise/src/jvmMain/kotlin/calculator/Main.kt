package calculator

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
        title = "Calculator Exercise Starter Project",
        state = rememberWindowState(
            size = DpSize(350.dp, 400.dp)
        )
    ) {
        CalculatorApp()
    }
}
