package pl.angulski.salarytracker.domain.salary

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 */
interface AddSalaryUseCase {
    fun execute(amountCents: Int, currencyCode: String, day: Int, month: Int, year: Int)
}

class AddSalary(
    private val repository: SalaryRepository,
    private val presenter: AddSalaryPresenter?
): AddSalaryUseCase {
    override fun execute(amountCents: Int, currencyCode: String, day: Int, month: Int, year: Int) {
        val salary = Salary(
            Money(
                currencyCode,
                amountCents
            ), Day(day, month, year)
        )
        repository.add(salary)
        presenter?.onSalaryAdded(salary)
    }
}

// TODO: change presenter to interface

class AddSalaryPresenter(val view: AddSalaryView) {
    fun onSalaryAdded(salary: Salary) {
        view.addViewState = AddSalaryViewState.NewSalary(salary)
    }
}

interface AddSalaryView {
    var addViewState: AddSalaryViewState
}

sealed class AddSalaryViewState {
    data class NewSalary(val salary: Salary) : AddSalaryViewState()
    data class Failure(val failure: Exception) : AddSalaryViewState()
}
