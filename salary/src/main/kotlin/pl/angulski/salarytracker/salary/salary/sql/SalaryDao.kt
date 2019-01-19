package pl.angulski.salarytracker.salary.salary.sql

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface SalaryDao {
    @Query("SELECT * FROM salaries")
    fun getAll(): List<Salary>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(salary: Salary)
}
