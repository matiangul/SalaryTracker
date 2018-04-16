package pl.angulski.salarytracker.domain.salary

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 */
interface GetSalariesUseCase {
    fun execute()
}

class GetSalaries(
    private val repository: SalaryRepository,
    private val presenter: GetSalariesPresenter
) : GetSalariesUseCase {
    override fun execute() {
        presenter.onSalariesGet(repository.getAll())
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
