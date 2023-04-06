package staff.search.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.onClick
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import staff.search.model.Employee

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StaffRow(employee: Employee) {
    val fullName = "${employee.name.first} ${employee.name.last}"
    Row {
        Text(
            fullName,
            modifier = Modifier
                .padding(start = 10.dp)
                .onClick { println("Clicked on $fullName") },
            style = TextStyle(fontSize = 12.sp)
        )
    }
}