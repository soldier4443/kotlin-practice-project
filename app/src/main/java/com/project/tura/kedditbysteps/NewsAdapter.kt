package com.project.tura.kedditbysteps

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.project.tura.kedditbysteps.delegates.LoadingDelegateAdapter
import com.project.tura.kedditbysteps.delegates.NewsDelegateAdapter
import com.project.tura.kedditbysteps.delegates.ViewTypeDelegateAdapter

/**
 * Created by nyh0111 on 2017-06-14.
 */

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private var items: ArrayList<ViewType>
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter())
        items = ArrayList()
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
//        return super.getItemViewType(position)
        return this.items[position].getViewType()
    }


    fun addNews(news: List<RedditNewsItem>) {
        val initPosition = items.size - 1
        items.addAll(initPosition, news)
        notifyItemRangeInserted(initPosition, news.size)
    }

    fun clearAndAddNews(news: List<RedditNewsItem>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())

        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getNews() : List<RedditNewsItem> {
        return items
                .filter { it.getViewType() == AdapterConstants.NEWS }   // filter only news
                .map { it as RedditNewsItem }                           // Cast each item as NewsItem (from ViewType)
    }

    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex
}