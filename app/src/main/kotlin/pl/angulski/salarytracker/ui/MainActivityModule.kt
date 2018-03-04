package pl.angulski.salarytracker.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.angulski.salarytracker.salary.AddSalary
import pl.angulski.salarytracker.salary.GetSalaries
import pl.angulski.salarytracker.salary.SalaryRepository
import pl.angulski.salarytracker.ui.salary.SalaryController
import pl.angulski.salarytracker.ui.salary.SalaryPresenter

@Module
class MainActivityModule {

    @Provides
    fun provideSalaryPresenter(view: MainActivity) = SalaryPresenter(view)

    @Provides
    fun provideAddSalary(repository: SalaryRepository, presenter: SalaryPresenter) =
        AddSalary(repository, presenter)

    @Provides
    fun provideGetSalaries(repository: SalaryRepository, presenter: SalaryPresenter) =
        GetSalaries(repository, presenter)

    @Provides
    fun provideSalaryController(addSalary: AddSalary, getSalaries: GetSalaries, ctx: Context) =
        SalaryController(addSalary, getSalaries, ctx.resources)
}
