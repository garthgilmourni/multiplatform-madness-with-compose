package desktop.hof

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
fun buildWindowState() = rememberWindowState(
    size = DpSize(800.dp, 500.dp),
    position = WindowPosition(100.dp, 100.dp)
)

fun buildSurveyField(label: String, size: TextUnit): @Composable (String) -> Unit {
    return { value: String ->
        val counterStyle = TextStyle(color = Color.Black, fontSize = size)
        Box(Modifier.padding(all = 10.dp)) {
            Column {
                Row {
                    Text(
                        label,
                        modifier = Modifier.padding(end = 10.dp),
                        style = counterStyle.plus(TextStyle(fontWeight = FontWeight.Bold))
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(value, style = counterStyle)
                    TextField(value = "your answer goes here...", onValueChange = {})
                }
                Divider(Modifier.padding(top = 10.dp, bottom = 10.dp))
            }
        }
    }
}

fun main() = application {
    Window(
        title = "Demo Of Generating Composable Functions",
        onCloseRequest = ::exitApplication,
        state = buildWindowState()
    ) {
        val LocationQuestion = remember { buildSurveyField("About Your Home", 18.sp) }
        val EmployementQuestion = remember { buildSurveyField("About Your Job", 20.sp) }

        MaterialTheme {
            Column {
                LocationQuestion("Where do you live?")
                LocationQuestion("How big is your house?")
                EmployementQuestion("How long have you worked for your employer?")
                EmployementQuestion("Do you like your manager?")
            }
        }
    }
}
