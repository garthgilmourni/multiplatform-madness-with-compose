package desktop.effects.movies.extended

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import desktop.model.cinema.Genre
import desktop.model.cinema.MovieSummary
import desktop.util.Header

@Composable
fun MoviesDisplay(
    currentGenre: Genre,
    moviesInGenre: List<MovieSummary>,
    onMovieSelected: (MovieSummary) -> Unit
) {
    Row {
        Header("Movies In The Genre $currentGenre")
    }
    Row {
        LazyColumn(modifier = Modifier.height(400.dp)) {
            itemsIndexed(moviesInGenre) { index, movie ->
                MovieRow(movie, index % 2 == 0, onMovieSelected)
            }
        }
    }
}