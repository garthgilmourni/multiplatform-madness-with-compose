package calculator

import calculator.Operation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*

@Composable
fun CalculatorApp(viewModel: CalculatorViewModel) {

    with(viewModel) {
        CalculatorTheme {
            Column {
                Row {
                    DisplayText(text = "$displayedTotal")
                }
                Row {
                    Column {
                        Row {
                            (1..3).forEach { num ->
                                NumberButton(num) { selectNumber(num) }
                            }
                        }
                        Row {
                            (4..6).forEach { num ->
                                NumberButton(num) { selectNumber(num) }
                            }
                        }
                        Row {
                            (7..9).forEach { num ->
                                NumberButton(num) { selectNumber(num) }
                            }
                        }
                        Row {
                            NumberButton(0) { selectNumber(0) }
                        }
                    }
                    Column {
                        OperationButton("+") { selectOperation(Add) }
                        OperationButton("-") { selectOperation(Subtract) }
                        OperationButton("*") { selectOperation(Multiply) }
                        OperationButton("/") { selectOperation(Divide) }
                        OperationButton("Clear", ::clearSelected)
                        OperationButton("=", ::selectEquals)
                    }
                }
            }
        }
    }
}

