package pl.angulski.salarytracker.salary.salary.sql

import pl.angulski.salarytracker.domain.salary.Salary
import pl.angulski.salarytracker.domain.salary.SalaryRepository

class SqlSalaryRepository(private val salaryDao: SalaryDao): SalaryRepository {

    override fun add(salary: Salary) {
        salaryDao.insert(salary.toEntity())
    }

    override fun getAll(): List<Salary> {
        return salaryDao.getAll().map { it.toDomainObj() }
    }
}
