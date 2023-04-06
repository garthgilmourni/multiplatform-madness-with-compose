package desktop.effects.movies.extended

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.onClick
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import desktop.model.cinema.Genre

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GenresDisplay(onSelected: (Genre) -> Unit) {
    Row {
        LazyColumn(modifier = Modifier.height(100.dp)) {
            items(Genre.values()) { genre ->
                Row(modifier = Modifier.onClick {
                    onSelected(genre)
                }) {
                    Text(genre.toString())
                }
            }
        }
    }
}