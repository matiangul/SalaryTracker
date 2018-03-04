package pl.angulski.salarytracker.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.angulski.salarytracker.app.MainActivity

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
