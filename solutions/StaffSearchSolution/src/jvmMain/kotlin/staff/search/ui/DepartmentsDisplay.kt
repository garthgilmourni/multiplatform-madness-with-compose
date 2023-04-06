package staff.search.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.onClick
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import staff.search.model.Department
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DepartmentRow(department: Department, onSelected: (Department) -> Unit) {
    Row(modifier = Modifier.onClick {
        onSelected(department)
    }) {
        Text(
            text = department.toString(),
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Composable
fun DepartmentsDisplay(onSelected: (Department) -> Unit) {
    Row {
        LazyColumn {
            items(Department.values()) { department ->
                DepartmentRow(department, onSelected)
            }
        }
    }
}