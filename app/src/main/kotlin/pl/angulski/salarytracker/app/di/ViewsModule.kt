package pl.angulski.salarytracker.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.angulski.salarytracker.app.MainActivity
import pl.angulski.salarytracker.app.salary.di.SalaryViewsModule

@Module
abstract class ViewsModule {

    @ContributesAndroidInjector(modules = [SalaryViewsModule::class])
    abstract fun bindMainActivity(): MainActivity
}
