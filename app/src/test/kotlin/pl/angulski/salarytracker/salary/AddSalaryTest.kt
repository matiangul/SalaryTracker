package pl.angulski.salarytracker.salary

import com.nhaarman.mockito_kotlin.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by Mateusz Angulski <mateusz.angulski@assertis.co.uk>
 */
@RunWith(MockitoJUnitRunner::class)
class AddSalaryTest {

    @InjectMocks
    lateinit var mInteractor: AddSalary

    @Mock
    lateinit var repository: SalaryRepository
    @Mock
    lateinit var presenter: AddSalaryPresenter

    @Before
    fun setUpInteractorUnderTest() {
        doNothing().whenever(repository).add(any<Salary>())
        doNothing().whenever(presenter).onSalaryAdded(any<Salary>())
    }

    @After
    fun verifyMockedDependencies() {
        reset(repository, presenter)
    }

    @Test
    fun execute_savesSalaryUsingRepository() {
        mInteractor.execute(100_00, "PLN", 1, 1, 2017)

        verify(repository).add(any<Salary>())
    }

    @Test
    fun execute_savesProperSalaryUsingRepository() {
        mInteractor.execute(100_00, "PLN", 1, 1, 2017)

        verify(repository).add(eq(Salary(Money("PLN", 100_00), Day(1, 1, 2017))))
    }

    @Test
    fun execute_callPresenterWithSavedSalary() {
        mInteractor.execute(100_00, "PLN", 1, 1, 2017)

        verify(presenter).onSalaryAdded(eq(Salary(Money("PLN", 100_00), Day(1, 1, 2017))))
    }
}
