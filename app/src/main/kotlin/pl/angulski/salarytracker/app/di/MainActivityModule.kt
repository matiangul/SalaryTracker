package pl.angulski.salarytracker.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.angulski.salarytracker.app.MainActivity
import pl.angulski.salarytracker.domain.salary.AddSalary
import pl.angulski.salarytracker.domain.salary.GetSalaries
import pl.angulski.salarytracker.domain.salary.SalaryRepository
import pl.angulski.salarytracker.app.salary.ui.SalaryController
import pl.angulski.salarytracker.app.salary.ui.SalaryPresenter

@Module
class MainActivityModule {

    @Provides
    fun provideSalaryPresenter(view: MainActivity) =
        SalaryPresenter(view)

    @Provides
    fun provideAddSalary(repository: SalaryRepository, presenter: SalaryPresenter) =
        AddSalary(repository, presenter)

    @Provides
    fun provideGetSalaries(repository: SalaryRepository, presenter: SalaryPresenter) =
        GetSalaries(repository, presenter)

    @Provides
    fun provideSalaryController(addSalary: AddSalary, getSalaries: GetSalaries, ctx: Context) =
        SalaryController(
            addSalary,
            getSalaries,
            ctx.resources
        )
}
