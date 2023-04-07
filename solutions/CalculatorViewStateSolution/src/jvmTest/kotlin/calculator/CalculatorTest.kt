package calculator

import androidx.compose.runtime.remember
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CalculatorTest {
    @get:Rule
    val compose = createComposeRule()

    @Test
    fun `should support addition`() {
        testCalculator {
            pushNumber(4)
            pushNumber(5)
            pushAdd()
            pushNumber(2)
            pushNumber(3)
            pushEquals()
            checkDisplay(68)
        }
    }

    @Test
    fun `should support subtraction`() {
        testCalculator {
            pushNumber(6)
            pushNumber(7)
            pushSubtract()
            pushNumber(5)
            pushNumber(1)
            pushEquals()
            checkDisplay(16)
        }
    }

    @Test
    fun `should support multiplication`() {
        testCalculator {
            pushNumber(1)
            pushNumber(2)
            pushMultiply()
            pushNumber(1)
            pushNumber(0)
            pushEquals()
            checkDisplay(120)
        }
    }

    @Test
    fun `should support division`() {
        testCalculator {
            pushNumber(1)
            pushNumber(2)
            pushNumber(0)
            pushDivide()
            pushNumber(6)
            pushEquals()
            checkDisplay(20)
        }
    }

    @Test
    fun `should support chained operations`() {
        testCalculator {
            pushNumber(1)
            pushNumber(2)
            pushMultiply()
            pushNumber(1)
            pushNumber(0)
            pushDivide()
            checkDisplay(120)
            pushNumber(6)
            pushNumber(0)
            pushAdd()
            checkDisplay(2)
            pushNumber(1)
            pushNumber(5)
            pushEquals()
            checkDisplay(17)
        }
    }

    private fun testCalculator(test: suspend () -> Unit) {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                val viewState = remember { CalculatorViewModel() }
                CalculatorApp(viewState)
            }
            compose.awaitIdle()

            test()
        }
    }

    private fun checkDisplay(total: Int) {
        compose.onNodeWithTag("Display")
            .assert(hasText(total.toString()))
    }

    private suspend fun pushNumber(number: Int): Unit {
        compose.onNodeWithTag("Number $number")
            .performClick()
        compose.awaitIdle()
    }

    private fun operationBuilder(label: String): suspend () -> Unit {
        return {
            compose.onNodeWithTag("Operation $label")
                .performClick()
            compose.awaitIdle()
        }
    }

    private val pushAdd = operationBuilder("+")
    private val pushSubtract = operationBuilder("-")
    private val pushMultiply = operationBuilder("*")
    private val pushDivide = operationBuilder("/")
    private val pushEquals = operationBuilder("=")
}