package movie.quotes

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import movie.quotes.components.MovieQuotesApp
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MovieQuotesTest {
    @get:Rule
    val compose = createComposeRule()

    @Test
    fun `should have an add quote button`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                MovieQuotesApp()
            }
            compose.awaitIdle()

            compose.onNodeWithText("Add New Quote")
                .assertExists("Add quote button not found");
        }
    }

    @Test
    fun `should have two text inputs`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                MovieQuotesApp()
            }
            compose.awaitIdle()

            compose.onNodeWithTag("Source Input")
                .assertExists("Source input not found")

            compose.onNodeWithTag("Quote Input")
                .assertExists("Quote input not found")
        }
    }

    @Test
    fun `should contain five quotations initially`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                MovieQuotesApp()
            }
            compose.awaitIdle()

            compose.onAllNodesWithTag("Quote Box")
                .assertCountEquals(5)
        }
    }

    @Test
    fun `should contain a quotation by Liet`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                MovieQuotesApp()
            }
            compose.awaitIdle()

            val characterName = "Liet"
            val quotation = "I serve only one master. His name is Shai-Hulud."
            compose.onAllNodesWithTag("Quote Box")
                .filter(hasAnyChild(hasText(characterName)))
                .assertCountEquals(1)
                .assertAll(hasAnyChild(hasText(quotation)))
        }
    }

    @Test
    fun `should allow a quote to be added with default values`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                MovieQuotesApp()
            }
            compose.awaitIdle()

            compose.onNodeWithText("Add New Quote")
                .performClick()
            compose.awaitIdle()

            compose.onAllNodesWithTag("Quote Box")
                .assertCountEquals(6)
                .onLast()
                .assert(hasAnyChild(hasText("default source")))
                .assert(hasAnyChild(hasText("default text")))
        }
    }

    @Test
    fun `should allow a quote to be added with custom values`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                MovieQuotesApp()
            }
            compose.awaitIdle()

            compose.onNodeWithTag("Source Input")
                .performTextReplacement("Shadout Mapes")
            compose.onNodeWithTag("Quote Input")
                .performTextReplacement("Kull wahad!")
            compose.awaitIdle()

            compose.onNodeWithText("Add New Quote")
                .performClick()
            compose.awaitIdle()

            val lastQuote = compose.onAllNodesWithTag("Quote Box")
                .assertCountEquals(6)
                .onLast()

            lastQuote
                .onChildAt(0)
                .assert(hasText("Shadout Mapes"))

            lastQuote
                .onChildAt(2)
                .assert(hasText("Kull wahad!"))
        }
    }

    @Test
    @Ignore
    fun `should not allow source to be empty`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                MovieQuotesApp()
            }
            compose.awaitIdle()

            compose.onNodeWithTag("Source Input")
                .performTextReplacement("")
            compose.awaitIdle()

            compose.onNodeWithText("Add New Quote")
                .performClick()
            compose.awaitIdle()

            compose.onAllNodesWithTag("Quote Box")
                .assertCountEquals(5)
        }
    }

    @Test
    @Ignore
    fun `should not allow content to be empty`() {
        val dispatcher = StandardTestDispatcher()
        val scope = TestScope(dispatcher)
        scope.runTest {
            compose.setContent {
                MovieQuotesApp()
            }
            compose.awaitIdle()

            compose.onNodeWithTag("Quote Input")
                .performTextReplacement("")
            compose.awaitIdle()

            compose.onNodeWithText("Add New Quote")
                .performClick()
            compose.awaitIdle()

            compose.onAllNodesWithTag("Quote Box")
                .assertCountEquals(5)
        }
    }
}