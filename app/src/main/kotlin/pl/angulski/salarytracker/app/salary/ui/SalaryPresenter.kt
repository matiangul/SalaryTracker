package pl.angulski.salarytracker.app.salary.ui

import pl.angulski.salarytracker.domain.salary.AddSalaryPresenter
import pl.angulski.salarytracker.domain.salary.GetSalariesPresenter
import pl.angulski.salarytracker.domain.salary.Salary

class SalaryPresenter(val view: SalaryView) : AddSalaryPresenter, GetSalariesPresenter {

    override fun onSalariesGet(salaries: List<Salary>) {
        view.viewState =
                SalaryViewState.SalaryList(salaries)
    }

    override fun onSalaryAdded(salary: Salary) {
        view.viewState = SalaryViewState.NewSalary(salary)
    }
}
