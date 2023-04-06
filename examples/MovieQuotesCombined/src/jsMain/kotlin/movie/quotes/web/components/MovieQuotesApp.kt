package movie.quotes.web.components

import androidx.compose.runtime.*
import movie.quotes.common.db.buildInitialQuotes
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

import movie.quotes.common.model.Quote

@Composable
fun MovieQuotesApp() {
    @Composable
    fun TextWithPadding(value: String) {
        Span({ style { paddingRight(20.px) } }) {
            Text(value)
        }
    }

    var quotes by remember {
        mutableStateOf(buildInitialQuotes())
    }

    var newSourceText by remember { mutableStateOf("default source") }
    var newContentText by remember { mutableStateOf("default text") }


    Div(attrs = { classes(QuoteStylesheet.topDivStyle) }) {
        quotes.forEach { QuoteBox(it) }

        Hr(attrs = { classes(QuoteStylesheet.hrStyle) })

        Div {
            TextWithPadding("New Source:")
            Input(type = InputType.Text) {
                value(newSourceText)
                onInput { event ->
                    newSourceText = event.value
                }
            }
        }

        Div {
            TextWithPadding("New Text:")
            Input(type = InputType.Text) {
                value(newContentText)
                onInput { event ->
                    newContentText = event.value
                }
            }
        }

        Div {
            Button(attrs = {
                onClick {
                    quotes = quotes + Quote(newSourceText, newContentText)
                }
            }) {
                Text("Add New Quote")
            }
        }
    }
}