package desktop.state.basic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

fun calculateValue1(): Int {
    println("Calculating value 1")
    return 101
}

fun calculateValue2(): Int {
    println("Calculating value 2")
    return 202
}

fun calculateValue3(): Int {
    println("Calculating value 3")
    return 303
}


@Composable
fun InitializingStateApp() {
    val value1 = calculateValue1()
    val value2 = remember { calculateValue2() }
    val value3 = remember { mutableStateOf(calculateValue3()) }

    Column {
        Row {
            Text(
                style = TextStyle(color = Color.Black, fontSize = 18.sp),
                text = "Values are $value1, $value2 and ${value3.value}"
            )
        }
        Row {
            Button(onClick = { value3.value += 1 }) {
                Text("Increment Value 3")
            }
        }
    }
}