package staff.search.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

import staff.search.io.StaffSearchClient
import staff.search.model.Department
import staff.search.model.Employee

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun StaffSearchApp(client: StaffSearchClient) {
    var staffInDept by remember { mutableStateOf(emptyList<Employee>()) }
    val selectedDept = remember { mutableStateOf(Department.values()[0]) }
    val selectedEmployee = remember { mutableStateOf<Employee?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(selectedDept.value) {
        staffInDept = client.fetchStaffByDept(selectedDept.value)
    }

    Scaffold {
        Column {
            SearchHeader(selectedDept.value)
            Rule()
            DepartmentsDisplay { department ->
                selectedDept.value = department
            }
            Rule()
            StaffDisplay(staffInDept) { id ->
                scope.launch {
                    selectedEmployee.value = client.fetchStaffById(id)
                }
            }
            Rule()
            Row {
                val selected = selectedEmployee.value
                if (selected != null) {
                    StaffDetails(selected)
                }
            }
        }
    }
}