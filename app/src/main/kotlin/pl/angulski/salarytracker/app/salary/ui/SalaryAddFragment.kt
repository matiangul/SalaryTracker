package pl.angulski.salarytracker.app.salary.ui

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import pl.angulski.salarytracker.app.R

class SalaryAddFragment : BottomSheetDialogFragment() {

    private var listener: Listener? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_salary_add, container, false)
        view.findViewById<Button>(R.id.salary_add_button).setOnClickListener {
            listener?.onAddSalary(view.findViewById<EditText>(R.id.salary_input).text.toString().toInt())
            dismiss()
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val parent = parentFragment
        if (parent != null) {
            listener = parent as Listener
        } else {
            listener = context as Listener?
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    interface Listener {
        fun onAddSalary(money: Int)
    }

    companion object {
        fun newInstance(): SalaryAddFragment {
            return SalaryAddFragment()
        }
    }
}
