package desktop.effects.movies.basic

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
fun buildWindowState() = rememberWindowState(
    size = DpSize(500.dp, 800.dp),
    position = WindowPosition(100.dp, 100.dp)
)

val client = MoviesClient("http://0.0.0.0:8080/cinema/")

fun main() = application {
    Window(
        title = "Demo of Side Effects and IO",
        onCloseRequest = ::exitApplication,
        state = buildWindowState(),
    ) {
        MoviesApp(client)
    }
}