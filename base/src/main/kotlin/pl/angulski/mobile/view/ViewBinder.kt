package pl.angulski.mobile.view

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Taken from project tropos-android
 * @see https://github.com/thoughtbot/tropos-android
 */
class ViewBinder<M>(val function: (M) -> Unit) : ReadWriteProperty<Any, M> {
    private var value: M? = null

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Any, property: KProperty<*>): M {
        return value as M
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: M) {
        this.value = value
        function(value)
    }
}
