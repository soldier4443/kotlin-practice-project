package com.project.tura.kedditbysteps

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by nyh0111 on 2017-06-26.
 */

class RestApi {

    private val redditApi : RedditApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())    // Setting up the Moshi converter
                .build()

        // class.java -> get java class
        redditApi = retrofit.create(RedditApi::class.java)
    }

    fun getNews(after: String, limit: String) = redditApi.getTop(after, limit)
}