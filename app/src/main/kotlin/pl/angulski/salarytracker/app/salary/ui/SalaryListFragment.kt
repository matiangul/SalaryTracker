package pl.angulski.salarytracker.app.salary.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_salary_list.*
import pl.angulski.mobile.view.ViewBinder
import pl.angulski.salarytracker.app.R
import pl.angulski.salarytracker.domain.salary.*
import javax.inject.Inject

class SalaryListFragment : DaggerFragment(), ListSalaryView, AddSalaryView {

    @Inject
    lateinit var getSalaries: GetSalariesUseCase

    private var visibleSalaries: MutableList<Salary> = mutableListOf()

    override var listViewState: ListSalaryViewState by ViewBinder {
        when (it) {
            is ListSalaryViewState.SalaryList -> {
                visibleSalaries.clear()
                visibleSalaries.addAll(it.salaries)
                textView.text = "Salaries ${visibleSalaries.size}"
            }
            is ListSalaryViewState.Failure -> {
                Snackbar.make(
                    view!!,
                    "Failed fetching salaries",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    override var addViewState: AddSalaryViewState by ViewBinder {
        when (it) {
            is AddSalaryViewState.NewSalary -> {
                visibleSalaries.add(it.salary)
                textView.text = "Salary added, now ${visibleSalaries.size}"
            }
            is AddSalaryViewState.Failure -> {
                Snackbar.make(
                    view!!,
                    "Failed adding salary",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_salary_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        getSalaries.execute()
    }

    companion object {
        fun newInstance(): SalaryListFragment {
            return SalaryListFragment()
        }
    }
}
