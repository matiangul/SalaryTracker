package pl.angulski.salarytracker.app.salary.ui.list

import pl.angulski.mobile.view.recycler.ViewType
import pl.angulski.salarytracker.domain.salary.Salary

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 */
enum class ViewTypes {
    LOADING, SALARIES
}

class LoadingViewType: ViewType {
    override fun getViewType() = ViewTypes.LOADING.ordinal
}

class SalaryViewType(val salary: Salary): ViewType {
    override fun getViewType() = ViewTypes.SALARIES.ordinal
}

fun List<Salary>.toViews(): List<SalaryViewType> {
    return this.map { salary -> SalaryViewType(salary) }
}

fun Salary.toView(): SalaryViewType {
    return SalaryViewType(this)
}
