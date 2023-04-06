package sample.services.routing

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

import sample.services.db.readMoviesFile
import sample.services.model.cinema.Genre
import sample.services.model.cinema.MovieSummary

val movies = readMoviesFile()

fun Application.configureCinema() {
    routing {
        route("/cinema") {
            get("/") {
                if (movies != null) {
                    val data = movies.map {
                        MovieSummary(it.title, it.year)
                    }
                    call.respond(data)
                }
                handleMissingMovies()
            }
            get("/title/{title}") {
                val title = call.parameters["title"]
                val movie = movies?.find { it.title == title }
                if (movie == null) {
                    call.respondText(
                        "No movie with title $title",
                        status = HttpStatusCode.NotFound
                    )
                } else {
                    call.respond(movie)
                }
            }
            get("/genre/{genre}") {
                val genre = Genre.valueOf(call.parameters["genre"] ?: "")
                val moviesOfGenre = movies?.filter { it.genres.contains(genre) }
                if (moviesOfGenre == null) {
                    call.respondText(
                        "No movies in genre $genre",
                        status = HttpStatusCode.NotFound
                    )
                } else {
                    val data = moviesOfGenre.map {
                        MovieSummary(it.title, it.year)
                    }
                    call.respond(data)
                }
            }
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.handleMissingMovies() {
    call.respondText(
        text = "Cannot find movies",
        status = HttpStatusCode.NotFound
    )
}

