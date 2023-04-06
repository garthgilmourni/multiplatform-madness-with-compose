package movie.quotes.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.TextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import movie.quotes.db.buildInitialQuotes
import movie.quotes.model.Quote

@Composable
@Preview
fun MovieQuotesApp() {
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
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            quotes.forEach { QuoteBox(it) }

            Divider(
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

