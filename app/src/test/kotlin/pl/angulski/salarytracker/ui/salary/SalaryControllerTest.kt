package pl.angulski.salarytracker.ui.salary

import com.nhaarman.mockito_kotlin.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.angulski.salarytracker.salary.AddSalaryUseCase
import pl.angulski.salarytracker.salary.GetSalariesUseCase

/**
 * Created by Mateusz Angulski <mateusz.angulski@assertis.co.uk>
 */
@RunWith(MockitoJUnitRunner::class)
class SalaryControllerTest {

    @InjectMocks
    lateinit var controller: SalaryController

    @Mock
    lateinit var add: AddSalaryUseCase
    @Mock
    lateinit var get: GetSalariesUseCase

    @Before
    fun setUpInteractorUnderTest() {
        doNothing().whenever(add).execute(any<Int>(), any<String>(), any<Int>(), any<Int>(),
                any<Int>())
        doNothing().whenever(get).execute()
    }

    @After
    fun resetMockedDependencies() {
        reset(add, get)
    }

    @Test
    fun add_runsAddUseCaseWithPassedParameters() {
        controller.add(100_00)

        verify(add).execute(eq(100_00), eq("PLN"), eq(1), eq(1), eq(2017))
    }

    @Test
    fun getAll_runsGetUseCase() {
        controller.getAll()

        verify(get).execute()
    }
}
