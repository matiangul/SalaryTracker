package pl.angulski.salarytracker.salary

/**
 * Created by Mateusz Angulski <mateusz@angulski.pl>
 *
 * @param salary salary that user earned
 * @param day day when user received the salary
 */
data class DailySalary(val salary: Salary, val day: Day)
