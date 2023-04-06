package desktop.effects.movies.extended

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.onClick
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import desktop.model.cinema.MovieSummary

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun MovieRow(movie: MovieSummary, isEven: Boolean, callback: (MovieSummary) -> Unit) {
    fun pickColor() = if (isEven) Color.LightGray else Color.White

    var backgroundColor by remember { mutableStateOf(pickColor()) }

    val style = remember {
        TextStyle(
            color = Color.Black,
            fontSize = 14.sp,
        )
    }

    val textModifier = remember {
        Modifier.padding(end = 10.dp)
    }

    val baseRowModifier = remember {
        Modifier
            .fillMaxWidth()
            .then(Modifier.onClick { callback(movie) })
            .then(Modifier.onPointerEvent(
                PointerEventType.Enter,
                onEvent = { backgroundColor = Color.Yellow }
            ))
            .then(Modifier.onPointerEvent(
                PointerEventType.Exit,
                onEvent = { backgroundColor = pickColor() }
            ))
    }

    val rowModifier = baseRowModifier.then(Modifier.background(color = backgroundColor))

    Row(modifier = rowModifier) {
        Text(
            movie.title,
            style = style,
            modifier = textModifier
        )
        Spacer(Modifier.weight(1f))
        Text(
            movie.year.toString(),
            style = style,
            modifier = textModifier
        )
    }
}