package pl.angulski.salarytracker.app.salary.ui

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import pl.angulski.salarytracker.app.R
import javax.inject.Inject

class AddSalaryDialogFragment : BottomSheetDialogFragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var addSalaryController: AddSalaryController

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return childFragmentInjector
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_salary_add, container, false)
        view.findViewById<Button>(R.id.salary_add_button).setOnClickListener {
            val amount = view.findViewById<EditText>(R.id.salary_input).text.toString().toInt()
            addSalaryController.add(amount)
            dismiss()
        }
        return view
    }

    companion object {
        fun newInstance(): AddSalaryDialogFragment {
            return AddSalaryDialogFragment()
        }
    }
}
