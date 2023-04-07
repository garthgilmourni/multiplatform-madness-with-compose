package calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import calculator.Operation.*

class CalculatorViewModel {
    var displayedTotal by mutableStateOf(0)
        private set

    private var savedTotal = 0
    private var operationOngoing = None
    private var operationJustChanged = false

    fun selectNumber(number: Int) {
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

    fun clearSelected() {
        displayedTotal = 0
        savedTotal = 0
        operationOngoing = None
        operationJustChanged = false
    }

    fun selectOperation(op: Operation) {
        operationJustChanged = true
        if (operationOngoing != None) {
            doOperation()
            savedTotal = displayedTotal
        }
        operationOngoing = op
    }

    fun selectEquals() {
        doOperation()
        operationOngoing = None
    }

    private fun doOperation() {
        val saved = savedTotal
        val displayed = displayedTotal
        val operation = operationOngoing

        displayedTotal = when (operation) {
            Add -> saved + displayed
            Subtract -> saved - displayed
            Multiply -> saved * displayed
            Divide -> saved / displayed
            else -> throw IllegalStateException("No operation to execute!")
        }
    }
}
