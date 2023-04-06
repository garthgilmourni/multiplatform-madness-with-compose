package movie.quotes.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import movie.quotes.model.Quote

@Composable
internal fun QuoteBox(quote: Quote) {
    val quoteStyle = TextStyle(color = Color.Black, fontSize = 18.sp)
    Row(modifier = Modifier.padding(bottom = 10.dp)) {
        Text(
            text = quote.source,
            style = quoteStyle.plus(TextStyle(fontWeight = FontWeight.Bold)),
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(":", style = quoteStyle)
        Text(
            text = quote.content,
            style = quoteStyle,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}