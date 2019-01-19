package pl.angulski.salarytracker.app.salary.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.ExperimentalCoroutinesApi
import pl.angulski.mobile.extension.scope
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

    @ExperimentalCoroutinesApi
    @Provides
    fun provideAddSalary(
        activity: MainActivity,
        repository: SalaryRepository,
        presenter: AddSalaryPresenter
    ): AddSalaryUseCase = AddSalary(repository, presenter, Main, activity.lifecycle.scope())

    @Provides
    fun provideAddSalaryController(
        addSalary: AddSalaryUseCase,
        ctx: Context
    ): AddSalaryController = AddSalaryController(addSalary, ctx.resources)
}
