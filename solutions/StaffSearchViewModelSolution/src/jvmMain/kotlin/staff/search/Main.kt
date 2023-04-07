package staff.search

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import staff.search.io.StaffSearchClient
import staff.search.ui.StaffSearchApp
import staff.search.ui.StaffSearchViewModel

@Composable
fun buildWindowState() = rememberWindowState().apply {
    size = DpSize(400.dp, 600.dp)
    position = WindowPosition(100.dp, 100.dp)
}

fun main() = application {
    val client = StaffSearchClient("http://0.0.0.0:8080/staff/")
    val scope = rememberCoroutineScope()
    val viewModel = remember { StaffSearchViewModel(client, scope) }

    Window(
        title = "Staff Search Exercise",
        onCloseRequest = ::exitApplication,
        state = buildWindowState(),
    ) {
        MaterialTheme {
            StaffSearchApp(viewModel)
        }
    }
}
