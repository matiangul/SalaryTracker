package pl.angulski.salarytracker.domain.salary

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 *
 * @param currencyCode ISO 4217 code of the currency
 * @param amountCents amount of money received in currency cents
 */
data class Money(private val currencyCode: String, private val amountCents: Int)
