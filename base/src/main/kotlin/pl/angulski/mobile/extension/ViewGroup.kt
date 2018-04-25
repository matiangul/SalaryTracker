package pl.angulski.mobile.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author @juanchosaravia https://github.com/juanchosaravia
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
