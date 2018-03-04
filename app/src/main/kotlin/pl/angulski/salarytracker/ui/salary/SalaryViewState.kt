package pl.angulski.salarytracker.ui.salary

import pl.angulski.salarytracker.salary.Salary

/**
 * Created by Mateusz Angulski <mateusz.angulski@assertis.co.uk>
 */
sealed class SalaryViewState {
    data class NewSalary(val salary: Salary) : SalaryViewState()
    data class SalaryList(val salaries: List<Salary>) : SalaryViewState()
}
