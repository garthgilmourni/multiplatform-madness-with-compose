package calculator.desktop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*

import calculator.common.Operation
import calculator.common.Operation.*

@Composable
fun CalculatorApp() {
    var savedTotal by remember { mutableStateOf(0) }
    var displayedTotal by remember { mutableStateOf(0) }
    var operationOngoing by remember { mutableStateOf(None) }
    var operationJustChanged by remember { mutableStateOf(false) }

    val numberSelected = { number: Int ->
        when {
            operationJustChanged -> {
                operationJustChanged = false
                savedTotal = displayedTotal
                displayedTotal = number
            }

            displayedTotal == 0 -> {
                displayedTotal = number
            }

            else -> {
                displayedTotal = (displayedTotal * 10) + number
            }
        }
    }

    val clearSelected = {
        displayedTotal = 0
        savedTotal = 0
        operationOngoing = None
        operationJustChanged = false
    }

    val doOperation = {
        val saved = savedTotal
        val displayed = displayedTotal

        displayedTotal = when (operationOngoing) {
            Add -> saved + displayed
            Subtract -> saved - displayed
            Multiply -> saved * displayed
            Divide -> saved / displayed
            else -> throw IllegalStateException("No operation to execute!")
        }
    }

    val operationSelected = { op: Operation ->
        operationJustChanged = true
        if (operationOngoing != None) {
            doOperation()
            savedTotal = displayedTotal
        }
        operationOngoing = op
    }

    val equalsSelected = {
        doOperation()
        operationOngoing = None
    }

    CalculatorTheme {
        Column {
            Row {
                DisplayText(text = "${displayedTotal}")
            }
            Row {
                Column {
                    Row {
                        (1..3).forEach { num ->
                            NumberButton(onClick = { numberSelected(num) }, number = num)
                        }
                    }
                    Row {
                        (4..6).forEach { num ->
                            NumberButton(onClick = { numberSelected(num) }, number = num)
                        }
                    }
                    Row {
                        (7..9).forEach { num ->
                            NumberButton(onClick = { numberSelected(num) }, number = num)
                        }
                    }
                    Row {
                        NumberButton(onClick = { numberSelected(0) }, number = 0)
                    }
                }
                Column {
                    listOf(
                        { operationSelected(Add) } to "+",
                        { operationSelected(Subtract) } to "-",
                        { operationSelected(Multiply) } to "*",
                        { operationSelected(Divide) } to "/",
                        clearSelected to "Clear",
                        equalsSelected to "="
                    ).forEach { (action, label) ->
                        OperationButton(onClick = action, label = label)
                    }
                }
            }
        }
    }
}

