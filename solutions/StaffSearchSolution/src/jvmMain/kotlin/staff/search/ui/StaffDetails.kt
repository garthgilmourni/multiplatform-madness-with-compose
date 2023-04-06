package staff.search.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import staff.search.model.Employee

@Composable
fun StaffDetail(name: String, value: Any) {
    val style = TextStyle(fontSize = 12.sp)

    Row {
        Text(
            text = name,
            style = style.plus(TextStyle(fontWeight = FontWeight.Bold))
        )
        Text(
            text = ":",
            modifier = Modifier.padding(start = 5.dp, end = 5.dp),
            style = style
        )
        Text(value.toString(), style = style)
    }
}


@Composable
fun StaffDetails(employee: Employee) {
    Column {
        Row {
            Column {
                with(employee) {
                    StaffDetail("Forename", name.first)
                    StaffDetail("Surname", name.last)
                    StaffDetail("Age", age)
                    StaffDetail("Department", dept)
                    StaffDetail("Salary", salary)
                    StaffDetail("Email", email)
                    StaffDetail("Phone", phone)
                    StaffDetail("Address", address)
                    StaffDetail("Salary", salary)
                }
            }
        }
        Row {
            LazyColumn {
                items(employee.contacts) { contact ->
                    StaffDetail("Contact ${contact.id}", contact.name)
                }
            }
        }
    }
}