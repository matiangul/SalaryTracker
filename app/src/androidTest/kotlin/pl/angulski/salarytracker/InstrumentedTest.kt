package pl.angulski.salarytracker

import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class InstrumentedTest {
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        val appContext = getTargetContext()
        assertEquals("pl.angulski.salarytracker", appContext.packageName)
    }
}
