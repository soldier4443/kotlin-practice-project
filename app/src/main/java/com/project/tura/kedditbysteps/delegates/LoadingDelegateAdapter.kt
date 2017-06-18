package com.project.tura.kedditbysteps.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.project.tura.kedditbysteps.R
import com.project.tura.kedditbysteps.ViewType
import com.project.tura.kedditbysteps.inflate

/**
 * Created by nyh0111 on 2017-06-14.
 */

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {}

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading))
}

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}