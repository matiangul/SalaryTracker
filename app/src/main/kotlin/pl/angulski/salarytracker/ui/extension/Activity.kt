package pl.angulski.salarytracker.ui.extension

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import pl.angulski.salarytracker.R

/**
 * Created by Mateusz Angulski <mateusz.angulski@assertis.co.uk>
 */
fun AppCompatActivity.changeFragment(fragment: Fragment, cleanStack: Boolean = false) {
    val ft = supportFragmentManager.beginTransaction()
    if (cleanStack) {
        clearBackStack()
    }
    ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter,
            R.anim.abc_popup_exit)
    ft.replace(R.id.view_container, fragment)
    ft.addToBackStack(null)
    ft.commit()
}

fun AppCompatActivity.clearBackStack() {
    val manager = supportFragmentManager
    if (manager.backStackEntryCount > 0) {
        val first = manager.getBackStackEntryAt(0)
        manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}

fun AppCompatActivity.onBackPressedWithFragments() {
    val fragmentManager = supportFragmentManager
    if (fragmentManager.backStackEntryCount > 1) {
        fragmentManager.popBackStack()
    } else {
        finish()
    }
}
