package pl.angulski.salarytracker.salary.salary.sql

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import pl.angulski.salarytracker.domain.salary.Day
import pl.angulski.salarytracker.domain.salary.Money
import pl.angulski.salarytracker.domain.salary.Salary as DomainSalary
import java.util.*

@Entity(tableName = "salaries", primaryKeys = ["salary_id"])
data class Salary(
    @ColumnInfo(name = "salary_id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "amount_cents")
    val amountCents: Int,
    @ColumnInfo(name = "currency_code")
    val currencyCode: String,
    @ColumnInfo(name = "day")
    val day: Day
) {
    fun toDomainObj(): DomainSalary = DomainSalary(
        Money(currencyCode, amountCents),
        day
    )
}

fun DomainSalary.toEntity(): Salary = Salary(
    amountCents = money.amountCents,
    currencyCode = money.currencyCode,
    day = day
)
