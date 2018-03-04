package pl.angulski.salarytracker.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.angulski.salarytracker.ui.MainActivity
import pl.angulski.salarytracker.ui.MainActivityModule

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
