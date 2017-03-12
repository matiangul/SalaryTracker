package pl.angulski.salarytracker.ui

/**
 * Created by Mateusz Angulski <mateusz.angulski@assertis.co.uk>
 */
sealed class SalaryViewState {
    object EmptySalaryViewState : SalaryViewState()
}
