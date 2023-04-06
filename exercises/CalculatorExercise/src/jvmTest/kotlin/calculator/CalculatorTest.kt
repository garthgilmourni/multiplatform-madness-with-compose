package calculator

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
    fun `the add operation exists`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                CalculatorApp()
            }

            compose.onNodeWithTag("Operation +")
                .assertExists("Cannot find Add button")
        }
    }

    @Test
    fun `the subtract operation exists`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                CalculatorApp()
            }

            compose.onNodeWithTag("Operation -")
                .assertExists("Cannot find Add button")
        }
    }

    @Test
    fun `pushing numbers 1-3 displays that number`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                CalculatorApp()
            }
            (1..3).forEach { num ->
                compose.onNodeWithTag("Number $num")
                    .performClick()
                compose.awaitIdle()

                compose.onNodeWithTag("Display")
                    .assert(hasText(num.toString()))
            }
        }
    }
}