package pl.angulski.salarytracker.app.salary.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.angulski.salarytracker.app.salary.ui.AddSalaryDialogFragment
import pl.angulski.salarytracker.app.salary.ui.SalaryListFragment

@Module
abstract class SalaryViewsModule {

    @ContributesAndroidInjector(modules = [SalaryFragmentsModule::class])
    abstract fun provideSalaryListFragment(): SalaryListFragment

    @ContributesAndroidInjector(modules = [AddSalaryFragmentModule::class])
    abstract fun provideAddSalaryDialogFragment(): AddSalaryDialogFragment
}
