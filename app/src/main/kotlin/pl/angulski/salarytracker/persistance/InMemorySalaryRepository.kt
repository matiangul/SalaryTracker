package pl.angulski.salarytracker.persistance

import pl.angulski.salarytracker.salary.Salary
import pl.angulski.salarytracker.salary.SalaryRepository

class InMemorySalaryRepository: SalaryRepository {

    private val salaries: MutableList<Salary> = mutableListOf()

    override fun add(salary: Salary) {
        salaries.add(salary)
    }

    override fun getAll(): List<Salary> {
        return salaries
    }
}
