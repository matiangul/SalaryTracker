package pl.angulski.salarytracker.app.salary.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.ExperimentalCoroutinesApi
import pl.angulski.mobile.extension.scope
import pl.angulski.salarytracker.app.salary.ui.SalaryListFragment
import pl.angulski.salarytracker.domain.salary.GetSalaries
import pl.angulski.salarytracker.domain.salary.GetSalariesPresenter
import pl.angulski.salarytracker.domain.salary.GetSalariesUseCase
import pl.angulski.salarytracker.domain.salary.SalaryRepository

@Module
class SalaryFragmentsModule {

    @Provides
    fun provideGetSalariesPresenter(
        view: SalaryListFragment
    ): GetSalariesPresenter = GetSalariesPresenter(view)

    @ExperimentalCoroutinesApi
    @Provides
    fun provideGetSalaries(
        fragment: SalaryListFragment,
        repository: SalaryRepository,
        presenter: GetSalariesPresenter
    ): GetSalariesUseCase = GetSalaries(repository, presenter, Main, fragment.lifecycle.scope())
}
