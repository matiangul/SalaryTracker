package pl.angulski.salarytracker

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class UnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }
}

//TODO: try kotlintest
//TODO: run with RobolectricGradleTestRunner like in tropos (need to override kotlintest base class)
