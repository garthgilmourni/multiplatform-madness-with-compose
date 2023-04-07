package staff.search.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.material.Scaffold

@Composable
@Preview
fun StaffSearchApp(viewModel: StaffSearchViewModel) {

    LaunchedEffect(viewModel.selectedDept) {
        viewModel.staffInDept = viewModel.fetchStaffByDept()
    }

    with(viewModel) {
        Scaffold {
            Column {
                SearchHeader(viewModel.selectedDept)
                Rule()
                DepartmentsDisplay { department ->
                    selectedDept = department
                }
                Rule()
                StaffDisplay(staffInDept) { id ->
                    fetchStaffById(id)
                }
                Rule()
                Row {
                    val selected = selectedEmployee
                    if (selected != null) {
                        StaffDetails(selected)
                    }
                }
            }
        }
    }
}