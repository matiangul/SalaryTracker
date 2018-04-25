package pl.angulski.salarytracker.app.salary.ui

import android.content.res.Resources
import pl.angulski.mobile.extension.currentLocale
import pl.angulski.salarytracker.domain.salary.AddSalaryUseCase
import java.util.*

class AddSalaryController(
    private val addSalary: AddSalaryUseCase,
    private val resources: Resources
) {
    fun add(amount: Int) {
        val currency = Currency.getInstance(resources.configuration.currentLocale())
        val today = Calendar.getInstance(resources.configuration.currentLocale())

        addSalary.execute(
            amount * 100, currency.currencyCode, today.get(Calendar.DAY_OF_MONTH),
            today.get(Calendar.MONTH), today.get(Calendar.YEAR)
        )
    }
}
