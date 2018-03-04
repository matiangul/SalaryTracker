package pl.angulski.salarytracker.domain

/**
 * @author Mateusz Angulski <mateusz.angulski@assertis.co.uk>
 */
data class User(
    val userId: Int,
    val coverUrl: String = "",
    val fullName: String = "",
    val email: String = "",
    val description: String = "",
    val followers: Int = 0
)
