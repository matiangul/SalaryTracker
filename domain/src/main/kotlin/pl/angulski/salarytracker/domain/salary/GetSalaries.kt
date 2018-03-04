package pl.angulski.salarytracker.domain.salary

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 */
class GetSalaries(val repository: SalaryRepository,
                  val presenter: GetSalariesPresenter
): GetSalariesUseCase {

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
