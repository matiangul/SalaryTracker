package pl.angulski.salarytracker.app.salary.di

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.angulski.salarytracker.app.MainActivity
import pl.angulski.salarytracker.app.salary.ui.AddSalaryController
import pl.angulski.salarytracker.domain.salary.AddSalary
import pl.angulski.salarytracker.domain.salary.AddSalaryPresenter
import pl.angulski.salarytracker.domain.salary.AddSalaryUseCase
import pl.angulski.salarytracker.domain.salary.SalaryRepository

@Module
class AddSalaryFragmentModule {

    @Provides
    fun provideAddSalaryPresenter(
        activity: MainActivity
    ): AddSalaryPresenter = AddSalaryPresenter(activity.getActiveAddSalaryView())

    @Provides
    fun provideAddSalary(
        repository: SalaryRepository,
        presenter: AddSalaryPresenter
    ): AddSalaryUseCase = AddSalary(repository, presenter)

    @Provides
    fun provideAddSalaryController(
        addSalary: AddSalaryUseCase,
        ctx: Context
    ): AddSalaryController = AddSalaryController(addSalary, ctx.resources)
}
