package pl.angulski.salarytracker.di.salary

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.angulski.salarytracker.persistance.InMemorySalaryRepository
import pl.angulski.salarytracker.salary.SalaryRepository
import javax.inject.Singleton

@Module
class SalaryModule {
    @Provides
    @Singleton
    fun provideSalaryRepository(ctx: Context): SalaryRepository = InMemorySalaryRepository()
}
