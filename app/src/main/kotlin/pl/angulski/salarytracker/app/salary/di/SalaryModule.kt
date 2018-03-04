package pl.angulski.salarytracker.app.salary.di

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.angulski.salarytracker.data.salary.InMemorySalaryRepository
import pl.angulski.salarytracker.domain.salary.SalaryRepository
import javax.inject.Singleton

@Module
class SalaryModule {
    @Provides
    @Singleton
    fun provideSalaryRepository(ctx: Context): SalaryRepository = InMemorySalaryRepository()
}
