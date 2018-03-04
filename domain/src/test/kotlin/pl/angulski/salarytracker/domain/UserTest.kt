package pl.angulski.salarytracker.domain

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UserTest {
    @Test
    fun user_has_id() {
        val user = User(1)
        assertEquals(1, user.userId)
    }
}
