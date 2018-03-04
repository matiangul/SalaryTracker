package pl.angulski.mobile.extension

import android.content.res.Configuration
import android.os.Build
import java.util.*

fun Configuration.currentLocale(): Locale {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return locales[0]
    } else {
        return locale
    }
}
