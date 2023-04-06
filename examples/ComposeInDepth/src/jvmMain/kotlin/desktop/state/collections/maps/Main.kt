package desktop.state.collections.maps

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
fun buildWindowState() = rememberWindowState(
    size = DpSize(300.dp, 250.dp),
    position = WindowPosition(100.dp, 100.dp)
)

fun main() = application {
    Window(
        title = "Demo Of Managing Map State",
        onCloseRequest = ::exitApplication,
        state = buildWindowState()
    ) {
        MapStateApp()
    }
}