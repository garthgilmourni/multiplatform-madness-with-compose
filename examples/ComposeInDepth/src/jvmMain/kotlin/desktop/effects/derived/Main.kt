package desktop.effects.derived

import androidx.compose.runtime.*
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
fun buildWindowState() = rememberWindowState(
    size = DpSize(600.dp, 300.dp),
    position = WindowPosition(100.dp, 100.dp)
)

fun main() = application {
    Window(
        title = "Derived State Demo",
        onCloseRequest = ::exitApplication,
        state = buildWindowState()
    ) {
        DerivedStateApp()
    }
}
