import androidx.compose.runtime.Composable
import movie.quotes.components.MovieQuotesApp

expect fun getPlatformName(): String

@Composable
internal fun App() = MovieQuotesApp(getPlatformName())