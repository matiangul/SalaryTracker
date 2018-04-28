package pl.angulski.salarytracker.app.salary.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.experimental.android.UI
import pl.angulski.mobile.extension.job
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

    @Provides
    fun provideGetSalaries(
        fragment: SalaryListFragment,
        repository: SalaryRepository,
        presenter: GetSalariesPresenter
    ): GetSalariesUseCase = GetSalaries(repository, presenter, UI, fragment.lifecycle.job())
}
