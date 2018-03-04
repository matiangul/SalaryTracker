package pl.angulski.salarytracker.domain.salary

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 */
interface SalaryRepository {
    fun add(salary: Salary)
    fun getAll(): List<Salary>
}
