package pl.angulski.salarytracker.domain.salary

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

interface GetSalariesUseCase {
    fun execute()
}

class GetSalaries(
    private val repository: SalaryRepository,
    private val presenter: GetSalariesPresenter,
    private val presenterContext: CoroutineContext,
    private val parentScope: CoroutineScope
) : GetSalariesUseCase {

    override fun execute() {
        parentScope.launch(context = presenterContext) {
            val result = withContext(Dispatchers.Default) {
                repository.getAll()
            }
            presenter.onSalariesGet(result)
        }
    }
}

class GetSalariesPresenter(val view: ListSalaryView) {
    fun onSalariesGet(salaries: List<Salary>) {
        view.listViewState = ListSalaryViewState.SalaryList(salaries)
    }
}

interface ListSalaryView {
    var listViewState: ListSalaryViewState
}

sealed class ListSalaryViewState {
    data class SalaryList(val salaries: List<Salary>) : ListSalaryViewState()
    data class Failure(val failure: Exception) : ListSalaryViewState()
}
