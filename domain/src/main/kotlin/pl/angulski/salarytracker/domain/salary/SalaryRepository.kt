package pl.angulski.salarytracker.domain.salary

interface SalaryRepository {
    fun add(salary: Salary)
    fun getAll(): List<Salary>
}
