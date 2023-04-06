package desktop.themes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ThemesApp() {
    val counter = remember { mutableStateOf(0) }
    CustomTheme {
        Box(Modifier.padding(10.dp)) {
            Column {
                Counter("Counter Value:", counter.value)

                Row {
                    Button(onClick = { counter.value += 1 }) {
                        Text("Update UI")
                    }
                }
            }
        }
    }
}