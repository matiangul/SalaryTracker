package pl.angulski.salarytracker.app.salary.ui.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import pl.angulski.mobile.extension.inflate
import pl.angulski.mobile.view.recycler.ViewType
import pl.angulski.mobile.view.recycler.ViewTypeDelegateAdapter
import pl.angulski.salarytracker.app.R

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) =
        LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        parent.inflate(R.layout.salary_list_item_loading))
}
