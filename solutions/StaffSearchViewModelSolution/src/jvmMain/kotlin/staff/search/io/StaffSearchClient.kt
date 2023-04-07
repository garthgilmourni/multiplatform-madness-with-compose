package staff.search.io

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import staff.search.model.Department
import staff.search.model.Employee

class StaffSearchClient(baseURL: String) {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(baseURL)
        }
    }

    suspend fun fetchAllStaff(): List<Employee> {
        val response = client.get("")
        return response.body()
    }

    suspend fun fetchStaffByDept(department: Department): List<Employee> {
        val response = client.get("dept/$department")
        return response.body()
    }

    suspend fun fetchStaffById(id: String): Employee {
        val response = client.get(id)
        return response.body()
    }
}