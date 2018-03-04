package pl.angulski.salarytracker.domain.salary

import com.nhaarman.mockito_kotlin.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetSalariesTest {

    @InjectMocks
    lateinit var mInteractor: GetSalaries

    @Mock
    lateinit var repository: SalaryRepository
    @Mock
    lateinit var presenter: GetSalariesPresenter

    @Before
    fun setUpInteractorUnderTest() {
        whenever(repository.getAll()).thenReturn(emptyList<Salary>())
        doNothing().whenever(presenter).onSalariesGet(any<List<Salary>>())
    }

    @After
    fun verifyMockedDependencies() {
        reset(repository, presenter)
    }

    @Test
    fun execute_getSalariesUsingRepository() {
        mInteractor.execute()

        verify(repository, times(1)).getAll()
    }

    @Test
    fun execute_callPresenterWithSavedSalary() {
        mInteractor.execute()

        verify(presenter, times(1)).onSalariesGet(eq(emptyList<Salary>()))
    }
}
