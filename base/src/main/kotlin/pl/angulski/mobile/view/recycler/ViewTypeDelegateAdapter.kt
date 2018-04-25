package pl.angulski.mobile.view.recycler

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * @author @juanchosaravia https://github.com/juanchosaravia
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}