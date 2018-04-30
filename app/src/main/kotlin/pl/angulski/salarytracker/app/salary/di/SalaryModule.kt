package pl.angulski.salarytracker.app.salary.di

import dagger.Module
import dagger.Provides
import pl.angulski.salarytracker.data.AppSqlDatabase
import pl.angulski.salarytracker.data.salary.sql.SqlSalaryRepository
import pl.angulski.salarytracker.domain.salary.SalaryRepository
import javax.inject.Singleton

@Module
class SalaryModule {

    @Provides
    @Singleton
    fun provideSalaryRepository(db: AppSqlDatabase): SalaryRepository =
        SqlSalaryRepository(db.salaryDao())
}
