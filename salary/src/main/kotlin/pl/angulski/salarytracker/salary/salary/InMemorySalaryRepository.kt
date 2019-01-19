package pl.angulski.salarytracker.salary.salary

import pl.angulski.salarytracker.domain.salary.Salary
import pl.angulski.salarytracker.domain.salary.SalaryRepository

class InMemorySalaryRepository: SalaryRepository {

    private val salaries: MutableList<Salary> = mutableListOf()

    override fun add(salary: Salary) {
        salaries.add(salary)
    }

    override fun getAll(): List<Salary> {
        return salaries
    }
}
