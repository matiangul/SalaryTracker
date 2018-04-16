package pl.angulski.salarytracker.app.extension

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import pl.angulski.mobile.extension.changeFragment as baseChangeFragment
import pl.angulski.salarytracker.app.R

fun AppCompatActivity.changeFragment(fragment: Fragment, cleanStack: Boolean = false) {
    baseChangeFragment(fragment, R.id.view_container, cleanStack)
}

fun AppCompatActivity.visibleFragment(): Fragment? {
    return supportFragmentManager.findFragmentById(R.id.view_container)
}
