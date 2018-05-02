package pl.angulski.salarytracker.app

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pl.angulski.mobile.extension.onBackPressedWithFragments
import pl.angulski.mobile.extension.showDialog
import pl.angulski.mobile.view.ViewBinder
import pl.angulski.salarytracker.app.R.layout.activity_main
import pl.angulski.salarytracker.app.extension.changeFragment
import pl.angulski.salarytracker.app.extension.visibleFragment
import pl.angulski.salarytracker.app.salary.ui.AddSalaryDialogFragment
import pl.angulski.salarytracker.app.salary.ui.SalaryListFragment
import pl.angulski.salarytracker.domain.salary.AddSalaryView
import pl.angulski.salarytracker.domain.salary.AddSalaryViewState

class MainActivity : DaggerAppCompatActivity(), AddSalaryView {

    override var addViewState: AddSalaryViewState by ViewBinder {
        when (it) {
            is AddSalaryViewState.NewSalary -> {
                Snackbar.make(view_container, "New salary", Snackbar.LENGTH_SHORT).show()
            }
            is AddSalaryViewState.Failure -> {
                Snackbar.make(view_container, "Failed adding salary", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        if (savedInstanceState == null) {
            changeFragment(SalaryListFragment.newInstance())
        }
        fab.setOnClickListener {
            showDialog(AddSalaryDialogFragment.newInstance())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.opt_menu_settings -> {
                Snackbar.make(view_container, "Open settings", Snackbar.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        onBackPressedWithFragments()
    }

    fun getActiveAddSalaryView(): AddSalaryView {
        return when(visibleFragment()) {
            is AddSalaryView -> visibleFragment() as AddSalaryView
            else -> this
        }
    }
}
