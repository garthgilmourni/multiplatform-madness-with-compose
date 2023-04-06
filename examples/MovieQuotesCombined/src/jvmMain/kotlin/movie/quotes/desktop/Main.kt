package movie.quotes.desktop

import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import movie.quotes.desktop.components.MovieQuotesApp

@Composable
fun buildWindowState() = rememberWindowState(
    size = DpSize(800.dp, 500.dp),
    position = WindowPosition(100.dp, 100.dp)
)

fun main() = application {
    Window(
        title = "Movie Quotes Demo",
        onCloseRequest = ::exitApplication,
        state = buildWindowState()
    ) {
        MovieQuotesApp()
    }
}
