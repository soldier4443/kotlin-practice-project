package com.project.tura.kedditbysteps.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.project.tura.kedditbysteps.*
import com.project.tura.kedditbysteps.R.layout.news_item
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by nyh0111 on 2017-06-15.
 */

class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    interface OnViewSelectedListener {
        fun onItemSelected(url: String?)
    }

    inner class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(news_item)) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            img_thumbnail.loadImage(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()

//            super.itemView.setOnClickListener { viewActions.onItemSelected(item.url) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }
}