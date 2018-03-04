package pl.angulski.salarytracker.salary

interface SalaryRepository {
    fun add(salary: Salary)
    fun getAll(): List<Salary>
}
