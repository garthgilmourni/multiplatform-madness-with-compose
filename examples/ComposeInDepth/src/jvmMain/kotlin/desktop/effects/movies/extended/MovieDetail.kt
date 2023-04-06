package desktop.effects.movies.extended

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import desktop.model.cinema.Movie
import desktop.util.Header
import desktop.util.SubHeader

@Composable
fun MovieDetail(movie: Movie?) {
    Row {
        if (movie == null) {
            Text("No movie selected")
        } else {
            Column {
                Row {
                    Header("${movie.title}: ${movie.year}")
                }
                Row {
                    SubHeader("Cast:")
                }
                Row {
                    LazyColumn {
                        items(movie.cast) { name ->
                            Row {
                                Text(name, modifier = Modifier.padding(start = 20.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}