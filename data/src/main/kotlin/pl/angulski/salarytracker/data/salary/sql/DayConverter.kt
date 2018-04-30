package pl.angulski.salarytracker.data.salary.sql

import android.arch.persistence.room.TypeConverter
import pl.angulski.salarytracker.domain.salary.Day

class DayConverter {
    @TypeConverter
    fun toDay(date: String?): Day? {
        return if (date == null) null else {
            val split = date.split("-")
            return Day(split[0].toInt(), split[1].toInt(), split[2].toInt())
        }
    }

    @TypeConverter
    fun toString(day: Day?): String? {
        return if (day == null) null else "${day.day}-${day.month}-${day.year}"
    }
}