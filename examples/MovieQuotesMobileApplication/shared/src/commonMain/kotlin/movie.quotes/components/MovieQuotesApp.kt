package movie.quotes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import movie.quotes.db.buildInitialQuotes
import movie.quotes.model.Quote

@Composable
internal fun MovieQuotesApp(platformName: String) {
    @Composable
    fun TextWithPadding(value: String) {
        Text(value, modifier = Modifier.padding(end = 20.dp))
    }

    var quotes by remember {
        mutableStateOf(buildInitialQuotes())
    }

    var newSourceText by remember { mutableStateOf("default source") }
    var newContentText by remember { mutableStateOf("default text") }

    MaterialTheme {
        Column(modifier = Modifier.padding(start = 10.dp, top = 20.dp)) {
            Header("Running on $platformName")

            quotes.forEach { QuoteBox(it) }

            TabRowDefaults.Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                TextWithPadding("New Source:")
                TextField(value = newSourceText, onValueChange = {
                    newSourceText = it
                })
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                TextWithPadding("New Text:")
                TextField(value = newContentText, onValueChange = {
                    newContentText = it
                })
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = {
                    quotes = quotes + Quote(newSourceText, newContentText)
                }) {
                    Text("Add New Quote")
                }
            }
        }
    }
}