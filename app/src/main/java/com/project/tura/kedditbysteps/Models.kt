package com.project.tura.kedditbysteps

/**
 * Created by nyh0111 on 2017-06-14.
 */

data class RedditNewsItem (
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}
