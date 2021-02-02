package com.tonatiuhcastro.albochallenge.punkapi.data.network.manager

import com.tonatiuhcastro.albochallenge.punkapi.data.network.response.BeerResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
interface BeerNetwork {
    @Headers("Content-Type:application/json")
    @GET("beers?")
    suspend fun getBeers(@Query("page") page: Int, @Query("per_page") items: Int) : List<BeerResponse>
}