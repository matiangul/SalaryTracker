package pl.angulski.salarytracker.app.di

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import pl.angulski.salarytracker.app.App
import pl.angulski.salarytracker.salary.AppSqlDatabase
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: App): Context = application

    @Provides
    @Singleton
    fun provideSqlDatabase(appContext: Context): AppSqlDatabase = Room.databaseBuilder(
        appContext,
        AppSqlDatabase::class.java,
        "salary-tracker-sql-db"
    ).build()
}
