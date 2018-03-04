package pl.angulski.salarytracker.domain.salary

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 *
 * @param money money that user earned
 * @param day day when user received her money
 */
data class Salary(val money: Money, val day: Day)