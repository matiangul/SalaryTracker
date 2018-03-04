package pl.angulski.salarytracker.ui.salary

import com.nhaarman.mockito_kotlin.isA
import com.nhaarman.mockito_kotlin.reset
import com.nhaarman.mockito_kotlin.verify
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.angulski.salarytracker.salary.Day
import pl.angulski.salarytracker.salary.Money
import pl.angulski.salarytracker.salary.Salary
import pl.angulski.salarytracker.ui.salary.SalaryPresenter
import pl.angulski.salarytracker.ui.salary.SalaryView
import pl.angulski.salarytracker.ui.salary.SalaryViewState

/**
 * Created by Mateusz Angulski <mateusz.angulski@assertis.co.uk>
 */
@RunWith(MockitoJUnitRunner::class)
class SalaryPresenterTest {

    @InjectMocks
    lateinit var presenter: SalaryPresenter

    @Mock
    lateinit var view: SalaryView

    @After
    fun resetMockedDependencies() {
        reset(view)
    }

    @Test
    fun onSalaryAdded_changeViewStateToNewSalary() {
        presenter.onSalaryAdded(Salary(Money("PLN", 100_00), Day(1, 1, 2017)))

        verify(view).viewState = isA<SalaryViewState.NewSalary>()
    }

    @Test
    fun onSalariesGet_changeViewStateToSalaryList() {
        presenter.onSalariesGet(emptyList())

        verify(view).viewState = isA<SalaryViewState.SalaryList>()
    }
}
