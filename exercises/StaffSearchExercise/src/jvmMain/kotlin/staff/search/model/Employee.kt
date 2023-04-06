package staff.search.model

import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val id: String,
    val name: Name,
    val age: Int,
    val salary: Double,
    val dept: Department,
    val email: String,
    val phone: String,
    val address: String,
    val contacts: List<Contact>
)
