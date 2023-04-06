package desktop.state.errors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import desktop.model.Person
import desktop.util.Rule

@Composable
fun ErrorsManagingStateApp() {
    val simpsonsList = remember {
        mutableStateOf(
            mutableListOf(
                Person("Homer", 39),
                Person("Marge", 36),
                Person("Bart", 10),
            )
        )
    }

    val flintstonesList = remember {
        mutableStateListOf(
            Person("Fred", 44),
            Person("Wilma", 43),
            Person("Pebbles", 2)
        )
    }

    MaterialTheme {
        Column {
            simpsonsList.value.forEach {
                Row { Text(it.toString()) }
            }
            Rule()

            flintstonesList.forEach {
                Row { Text(it.toString()) }
            }
            Rule()

            Row {
                Button(onClick = {
                    //This will not cause a recomposition
                    simpsonsList.value
                        .removeAt(0)

                    //This will not cause a recomposition
                    simpsonsList.value
                        .add(Person("Snowball", 3))
                }) {
                    Text("Update Simpsons")
                }

                Button(
                    modifier = Modifier.padding(start = 10.dp),
                    onClick = {
                        flintstonesList.removeAt(0)
                        flintstonesList.add(Person("Dino", 5))
                    }
                ) {
                    Text("Update Flintstones")
                }
            }
        }
    }
}