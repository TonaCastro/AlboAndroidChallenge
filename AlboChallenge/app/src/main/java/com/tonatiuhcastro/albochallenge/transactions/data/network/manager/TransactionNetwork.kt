package com.tonatiuhcastro.albochallenge.transactions.data.network.manager

import com.tonatiuhcastro.albochallenge.transactions.data.network.response.TransactionResponse
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
interface TransactionNetwork {
    @Headers("Content-Type:application/json")
    @GET("astrocumbia/06ec83050ec79170b10a11d1d4924dfe/raw/ad791cddcff6df2ec424bfa3da7cdb86f266c57e/transactions.json")
    suspend fun getTransactions() : List<TransactionResponse>
}