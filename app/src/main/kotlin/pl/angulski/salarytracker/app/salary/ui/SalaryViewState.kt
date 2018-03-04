package pl.angulski.salarytracker.app.salary.ui

import pl.angulski.salarytracker.domain.salary.Salary

sealed class SalaryViewState {
    data class NewSalary(val salary: Salary) : SalaryViewState()
    data class SalaryList(val salaries: List<Salary>) : SalaryViewState()
}
