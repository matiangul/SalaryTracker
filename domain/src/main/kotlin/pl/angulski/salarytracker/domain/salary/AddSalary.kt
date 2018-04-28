package pl.angulski.salarytracker.domain.salary

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

interface AddSalaryUseCase {
    fun execute(amountCents: Int, currencyCode: String, day: Int, month: Int, year: Int)
}

class AddSalary(
    private val repository: SalaryRepository,
    private val presenter: AddSalaryPresenter,
    private val presenterContext: CoroutineContext,
    private val parentJob: Job? = null
) : AddSalaryUseCase {

    override fun execute(amountCents: Int, currencyCode: String, day: Int, month: Int, year: Int) {
        val salary = Salary(
            Money(
                currencyCode,
                amountCents
            ), Day(day, month, year)
        )

        launch(CommonPool, parent = parentJob) { repository.add(salary) }
        launch(presenterContext, parent = parentJob) { presenter.onSalaryAdded(salary) }
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
