package pl.angulski.salarytracker.salary

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import pl.angulski.salarytracker.salary.salary.sql.DayConverter
import pl.angulski.salarytracker.salary.salary.sql.Salary
import pl.angulski.salarytracker.salary.salary.sql.SalaryDao

@Database(entities = [Salary::class], version = 1)
@TypeConverters(DayConverter::class)
abstract class AppSqlDatabase : RoomDatabase() {
    abstract fun salaryDao(): SalaryDao
}
