package pl.angulski.salarytracker.app.salary.ui.list

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import pl.angulski.mobile.view.recycler.ViewType
import pl.angulski.mobile.view.recycler.ViewTypeDelegateAdapter
import pl.angulski.salarytracker.domain.salary.Salary
import java.util.ArrayList

class SalariesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: ArrayList<ViewType> = ArrayList()
    private val delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = LoadingViewType()

    init {
        delegateAdapters.put(
            ViewTypes.LOADING.ordinal,
            LoadingDelegateAdapter()
        )
        delegateAdapters.put(
            ViewTypes.SALARIES.ordinal,
            SalariesDelegateAdapter()
        )
        items.add(loadingItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return this.items[position].getViewType()
    }

    fun addSalary(salary: Salary) {
        items.add(salary.toView())
        notifyItemInserted(items.lastIndex)
    }

    fun replaceSalaries(salaries: List<Salary>) {
        items.clear()
        items.addAll(salaries.toViews())
        notifyDataSetChanged()
    }
}
