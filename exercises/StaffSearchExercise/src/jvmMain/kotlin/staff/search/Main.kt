package staff.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import staff.search.io.StaffSearchClient
import staff.search.ui.StaffSearchApp

val client = StaffSearchClient("http://0.0.0.0:8080/staff/")

@Composable
fun buildWindowState() = rememberWindowState(
    size = DpSize(300.dp, 400.dp),
    position = WindowPosition(100.dp, 100.dp)
)

fun main() = application {
    Window(
        title = "Staff Search Exercise",
        onCloseRequest = ::exitApplication,
        state = buildWindowState(),
    ) {
        StaffSearchApp(client)
    }
}
