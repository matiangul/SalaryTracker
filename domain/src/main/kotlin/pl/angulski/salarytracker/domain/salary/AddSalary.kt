package pl.angulski.salarytracker.domain.salary

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

interface AddSalaryUseCase {
    fun execute(amountCents: Int, currencyCode: String, day: Int, month: Int, year: Int)
}

class AddSalary(
    private val repository: SalaryRepository,
    private val presenter: AddSalaryPresenter,
    private val presenterContext: CoroutineContext,
    private val parentScope: CoroutineScope
    ) : AddSalaryUseCase {

    override fun execute(amountCents: Int, currencyCode: String, day: Int, month: Int, year: Int) {
        val salary = Salary(
            Money(
                currencyCode,
                amountCents
            ), Day(day, month, year)
        )

        parentScope.launch(context = presenterContext) {
            withContext(Dispatchers.Default) {
                repository.add(salary)
            }
            presenter.onSalaryAdded(salary)
        }
    }
}

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
