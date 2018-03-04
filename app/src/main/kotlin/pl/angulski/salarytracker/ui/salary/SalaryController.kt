package pl.angulski.salarytracker.ui.salary

import android.content.res.Resources
import pl.angulski.salarytracker.salary.AddSalaryUseCase
import pl.angulski.salarytracker.salary.GetSalariesUseCase
import pl.angulski.salarytracker.ui.extension.currentLocale
import java.util.*

/**
 * Created by Mateusz Angulski <mateusz.angulski@assertis.co.uk>
 */
class SalaryController(val addSalary: AddSalaryUseCase, val getSalaries: GetSalariesUseCase,
                       val resources: Resources) {

    fun add(amountCents: Int) {
        val currency = Currency.getInstance(resources.configuration.currentLocale())
        val today = Calendar.getInstance(resources.configuration.currentLocale())

        addSalary.execute(amountCents, currency.currencyCode, today.get(Calendar.DAY_OF_MONTH),
                today.get(Calendar.MONTH), today.get(Calendar.YEAR))
    }

    fun getAll() {
        getSalaries.execute()
    }
}
