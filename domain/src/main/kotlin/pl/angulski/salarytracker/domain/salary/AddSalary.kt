package pl.angulski.salarytracker.domain.salary

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 */
class AddSalary(val repository: SalaryRepository,
                val presenter: AddSalaryPresenter
): AddSalaryUseCase {

    override fun execute(amountCents: Int, currencyCode: String, day: Int, month: Int, year: Int) {
        val salary = Salary(
            Money(
                currencyCode,
                amountCents
            ), Day(day, month, year)
        )
        repository.add(salary)
        presenter.onSalaryAdded(salary)
    }
}

interface AddSalaryPresenter {
    fun onSalaryAdded(salary: Salary)
}

interface AddSalaryUseCase {
    fun execute(amountCents: Int, currencyCode: String, day: Int, month: Int, year: Int)
}