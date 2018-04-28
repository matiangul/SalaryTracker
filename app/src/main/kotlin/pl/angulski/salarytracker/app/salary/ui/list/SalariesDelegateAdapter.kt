package pl.angulski.salarytracker.app.salary.ui.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.salary_list_item.view.*
import pl.angulski.mobile.extension.inflate
import pl.angulski.mobile.view.recycler.ViewType
import pl.angulski.mobile.view.recycler.ViewTypeDelegateAdapter
import pl.angulski.salarytracker.app.R

class SalariesDelegateAdapter: ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return SalaryViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as SalaryViewHolder
        holder.bind(item as SalaryViewType)
    }

    inner class SalaryViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.salary_list_item)) {

        fun bind(item: SalaryViewType) = with(itemView) {
            amount.text = "${item.salary.money.amountCents / 100} zł"
        }
    }
}
