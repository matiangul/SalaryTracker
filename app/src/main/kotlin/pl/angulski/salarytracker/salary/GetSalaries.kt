package pl.angulski.salarytracker.salary

/**
 * Created by Mateusz Angulski <mateusz.angulski@assertis.co.uk>
 */
class GetSalaries(val repository: SalaryRepository,
                  val presenter: GetSalariesPresenter): GetSalariesUseCase {

    override fun execute() {
        presenter.onSalariesGet(repository.getAll())
    }
}

interface GetSalariesPresenter {
    fun onSalariesGet(salaries: List<Salary>)
}

interface GetSalariesUseCase {
    fun execute(): Unit
}
