package pl.angulski.salarytracker.domain.salary

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

interface GetSalariesUseCase {
    fun execute()
}

class GetSalaries(
    private val repository: SalaryRepository,
    private val presenter: GetSalariesPresenter,
    private val presenterContext: CoroutineContext,
    private val parentJob: Job? = null
) : GetSalariesUseCase {

    override fun execute() {
        val result = async(CommonPool, parent = parentJob) { repository.getAll() }
        launch(presenterContext, parent = parentJob) { presenter.onSalariesGet(result.await()) }
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
