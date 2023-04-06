package staff.search.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun StaffRow(it: Employee, staffSelected: (String) -> Unit) {
    Row(modifier = Modifier.onClick { staffSelected(it.id) }) {
        Text(
            "${it.name.first} ${it.name.last}",
            modifier = Modifier.padding(start = 10.dp),
            style = TextStyle(fontSize = 14.sp)
        )
    }
}

@Composable
fun StaffDisplay(staff: List<Employee>, staffSelected: (String) -> Unit) {
    Row {
        LazyColumn(modifier = Modifier.height(200.dp)) {
            items(staff) {
                StaffRow(it, staffSelected)
            }
        }
    }
}