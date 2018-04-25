package pl.angulski.salarytracker.app.salary.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_salary_list.*
import pl.angulski.mobile.extension.inflate
import pl.angulski.mobile.view.recycler.InfiniteScrollListener
import pl.angulski.mobile.view.ViewBinder
import pl.angulski.salarytracker.app.R
import pl.angulski.salarytracker.app.salary.ui.list.SalariesAdapter
import pl.angulski.salarytracker.domain.salary.*
import javax.inject.Inject

class SalaryListFragment : DaggerFragment(), ListSalaryView, AddSalaryView {

    @Inject
    lateinit var getSalaries: GetSalariesUseCase

    override var listViewState: ListSalaryViewState by ViewBinder {
        when (it) {
            is ListSalaryViewState.SalaryList ->
                (salary_list.adapter as SalariesAdapter).replaceSalaries(it.salaries)
            is ListSalaryViewState.Failure ->
                showShortErrorMessage("Failed fetching salaries")
        }
    }

    override var addViewState: AddSalaryViewState by ViewBinder {
        when (it) {
            is AddSalaryViewState.NewSalary ->
                (salary_list.adapter as SalariesAdapter).addSalary(it.salary)
            is AddSalaryViewState.Failure ->
                showShortErrorMessage("Failed adding salary")
        }
    }

    private fun showShortErrorMessage(text: String) {
        Snackbar.make(
            salary_list, text, Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.fragment_salary_list)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        salary_list.apply {
            setHasFixedSize(true)
            clearOnScrollListeners()
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            addOnScrollListener(InfiniteScrollListener({ getSalaries.execute() }, linearLayout))
        }

        initAdapter()

        getSalaries.execute()
    }

    private fun initAdapter() {
        if (salary_list.adapter == null) {
            salary_list.adapter = SalariesAdapter()
        }
    }

    companion object {
        fun newInstance(): SalaryListFragment {
            return SalaryListFragment()
        }
    }
}
