package com.project.tura.kedditbysteps

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by nyh0111 on 2017-06-26.
 */

interface RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String)
    : Call<RedditNewsResponse>
}
