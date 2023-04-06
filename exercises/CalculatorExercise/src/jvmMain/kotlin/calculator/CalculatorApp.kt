package calculator

import calculator.Operation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*

@Composable
fun CalculatorApp() {
    var displayedTotal by remember { mutableStateOf(0) }

    CalculatorTheme {
        Column {
            Row {
                DisplayText(text = "$displayedTotal")
            }
            Row {
                Column {
                    Row {
                        NumberButton(1) { displayedTotal = 1 }
                        NumberButton(2) { displayedTotal = 2 }
                        NumberButton(3) { displayedTotal = 3 }
                    }
                }
                Column {
                    OperationButton("+") { println("You clicked $Add") }
                    OperationButton("-") { println("You clicked $Subtract") }
                }
            }
        }
    }
}

