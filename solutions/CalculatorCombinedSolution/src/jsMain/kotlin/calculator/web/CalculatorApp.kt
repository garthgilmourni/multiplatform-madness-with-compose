package calculator.web

import androidx.compose.runtime.*
import calculator.common.Operation
import calculator.web.CalculatorStylesheet.column
import calculator.web.CalculatorStylesheet.buttonsColumn
import calculator.web.CalculatorStylesheet.boxed
import calculator.web.CalculatorStylesheet.operationsColumn
import org.jetbrains.compose.web.dom.Div

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

            displayedTotal == 0 -> displayedTotal = number

            else -> displayedTotal = (displayedTotal * 10) + number
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

    Div({ classes(boxed) }) {
        Div {
            DisplayText(text = "$displayedTotal")
        }
        Div({ classes(boxed, column, buttonsColumn) }) {
            Div {
                (1..3).forEach { num ->
                    NumberButton(callback = { numberSelected(num) }, number = num)
                }
            }
            Div {
                (4..6).forEach { num ->
                    NumberButton(callback = { numberSelected(num) }, number = num)
                }
            }
            Div {
                (7..9).forEach { num ->
                    NumberButton(callback = { numberSelected(num) }, number = num)
                }
            }
            Div {
                NumberButton(callback = { numberSelected(0) }, number = 0)
            }
        }
        Div({ classes(boxed, column, operationsColumn) }) {
            listOf(
                { operationSelected(Add) } to "+",
                { operationSelected(Subtract) } to "-",
                { operationSelected(Multiply) } to "*",
                { operationSelected(Divide) } to "/",
                clearSelected to "Clear",
                equalsSelected to "="
            ).forEach {(action, label) ->
                Div {
                    OperationButton(callback = action, label = label)
                }
            }
        }
    }
}