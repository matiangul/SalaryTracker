package pl.angulski.mobile.extension

import android.support.annotation.IdRes
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import pl.angulski.mobile.R

/**
 * @author Mateusz Angulski <mateusz@angulski.pl>
 */
fun AppCompatActivity.changeFragment(
    fragment: Fragment,
    @IdRes containerViewId: Int,
    cleanStack: Boolean = false
) {
    val ft = supportFragmentManager.beginTransaction()
    if (cleanStack) {
        clearBackStack()
    }
    ft.setCustomAnimations(
        R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter,
        R.anim.abc_popup_exit
    )
    ft.replace(containerViewId, fragment)
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

fun AppCompatActivity.showDialog(dialog: DialogFragment) {
    dialog.show(
        supportFragmentManager, dialog::class.java.canonicalName
    )
}
