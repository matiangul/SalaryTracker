package pl.angulski.salarytracker.app.salary.ui

import android.content.res.Configuration
import android.content.res.Resources
import com.nhaarman.mockito_kotlin.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import pl.angulski.salarytracker.domain.salary.AddSalaryUseCase
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class AddSalaryControllerTest {

    private lateinit var controller: AddSalaryController

    private val add: AddSalaryUseCase = mock()
    private val resources: Resources = mock()
    private val configuration: Configuration = mock()

    @Before
    fun setUpInteractorUnderTest() {
        doNothing().whenever(add).execute(any<Int>(), any<String>(), any<Int>(), any<Int>(),
                any<Int>())
        configuration.locale = Locale("th", "TH", "TH")
        whenever(resources.configuration).thenReturn(configuration)

        controller = AddSalaryController(add, resources)
    }

    @After
    fun resetMockedDependencies() {
        reset(add, resources)
    }

    @Test
    fun add_runsAddUseCaseWithPassedParameters() {
        val calendar = Calendar.getInstance(configuration.locale)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        controller.add(100_00)

        verify(add).execute(eq(100_00), eq("THB"), eq(day), eq(month), eq(year))
    }
}
