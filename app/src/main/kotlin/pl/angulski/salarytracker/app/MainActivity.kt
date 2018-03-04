package pl.angulski.salarytracker.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import pl.angulski.salarytracker.app.extension.changeFragment
import pl.angulski.salarytracker.app.R
import pl.angulski.salarytracker.domain.salary.Salary
import pl.angulski.mobile.view.ViewBinder
import pl.angulski.mobile.extension.onBackPressedWithFragments
import pl.angulski.salarytracker.app.salary.ui.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    SalaryView, SalaryAddFragment.Listener {

    @Inject
    lateinit var controller: SalaryController

    private var visibleSalaries: MutableList<Salary> = mutableListOf()

    override var viewState: SalaryViewState by ViewBinder {
        when (it) {
            is SalaryViewState.NewSalary -> {
                visibleSalaries.add(it.salary)
            }
            is SalaryViewState.SalaryList -> {
                visibleSalaries.run {
                    clear()
                    addAll(it.salaries)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            changeFragment(SalaryListFragment.newInstance())
        }
        fab.setOnClickListener {
            showAddSalaryFragment()
        }
    }

    private fun showAddSalaryFragment() {
        SalaryAddFragment.newInstance().show(
                supportFragmentManager, SalaryAddFragment::class.java.canonicalName)
    }

    override fun onAddSalary(money: Int) {
        controller.add(money)
    }

    override fun onBackPressed() {
        onBackPressedWithFragments()
    }
}
