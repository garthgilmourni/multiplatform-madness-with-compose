package desktop.effects.movies.extended

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import desktop.model.cinema.Genre
import desktop.model.cinema.Movie
import desktop.model.cinema.MovieSummary
import desktop.util.Rule
import kotlinx.coroutines.launch


@Composable
fun MoviesApp(client: MoviesClient) {
    val selectedGenre = remember { mutableStateOf(Genre.values()[0]) }
    val moviesInGenre = remember { mutableStateOf(emptyList<MovieSummary>()) }
    val selectedMovie = remember { mutableStateOf<Movie?>(null) }
    val scope = rememberCoroutineScope()

    fun fetchMovieByTitle(summary: MovieSummary) {
        scope.launch {
            selectedMovie.value = client.fetchMovieByTitle(summary.title)
        }
    }

    LaunchedEffect(selectedGenre.value) {
        moviesInGenre.value = client.fetchMoviesByGenre(selectedGenre.value)
    }

    MaterialTheme {
        Box(modifier = Modifier.padding(10.dp)) {
            Column {
                MovieHeader()
                GenresDisplay { selectedGenre.value = it }
                Rule()
                MoviesDisplay(
                    selectedGenre.value,
                    moviesInGenre.value,
                    ::fetchMovieByTitle
                )
                Rule()
                MovieDetail(selectedMovie.value)
            }
        }
    }
}