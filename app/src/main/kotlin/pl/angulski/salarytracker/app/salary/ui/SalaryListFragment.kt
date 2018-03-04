package pl.angulski.salarytracker.app.salary.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.angulski.salarytracker.app.R

class SalaryListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_salary_list, container, false)
    }

    companion object {
        fun newInstance(): SalaryListFragment {
            return SalaryListFragment()
        }
    }
}
