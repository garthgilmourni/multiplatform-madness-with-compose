package staff.search.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import staff.search.io.StaffSearchClient
import staff.search.model.Department
import staff.search.model.Employee

class StaffSearchViewModel(
    private val client: StaffSearchClient,
    private val scope: CoroutineScope
) {
    var staffInDept by mutableStateOf(emptyList<Employee>())
    var selectedDept by mutableStateOf(Department.values()[0])
    var selectedEmployee by mutableStateOf<Employee?>(null)

    suspend fun fetchStaffByDept() = client.fetchStaffByDept(selectedDept)

    fun fetchStaffById(id: String) {
        scope.launch {
            selectedEmployee = client.fetchStaffById(id)
        }
    }
}