package pl.angulski.salarytracker.domain.salary

import com.nhaarman.mockito_kotlin.isA
import com.nhaarman.mockito_kotlin.reset
import com.nhaarman.mockito_kotlin.verify
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SalaryPresenterTest {

    @InjectMocks
    lateinit var presenter: AddSalaryPresenter

    @Mock
    lateinit var view: AddSalaryView

    @After
    fun resetMockedDependencies() {
        reset(view)
    }

    @Test
    fun onSalaryAdded_changeViewStateToNewSalary() {
        presenter.onSalaryAdded(
            Salary(
                Money(
                    "PLN",
                    100_00
                ), Day(1, 1, 2017)
            )
        )

        verify(view).addViewState = isA<AddSalaryViewState.NewSalary>()
    }
}
