package pl.angulski.salarytracker.ui.salary

import pl.angulski.salarytracker.salary.AddSalaryPresenter
import pl.angulski.salarytracker.salary.GetSalariesPresenter
import pl.angulski.salarytracker.salary.Salary

class SalaryPresenter(val view: SalaryView): AddSalaryPresenter, GetSalariesPresenter {

    override fun onSalariesGet(salaries: List<Salary>) {
        view.viewState = SalaryViewState.SalaryList(salaries)
    }

    override fun onSalaryAdded(salary: Salary) {
        view.viewState = SalaryViewState.NewSalary(salary)
    }
}
