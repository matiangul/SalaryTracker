package pl.angulski.salarytracker.domain.salary

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 *
 * @param day day of the month which usually is 1..31
 * @param month one of 1..12
 * @param year year of our era
 */
data class Day(val day: Int, val month: Int, val year: Int)
