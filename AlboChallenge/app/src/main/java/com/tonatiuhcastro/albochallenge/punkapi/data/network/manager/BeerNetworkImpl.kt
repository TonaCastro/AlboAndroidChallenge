package com.tonatiuhcastro.albochallenge.punkapi.data.network.manager

import com.tonatiuhcastro.albochallenge.common.network.NetworkConnectionImpl
import com.tonatiuhcastro.albochallenge.punkapi.data.network.response.BeerResponse
import com.tonatiuhcastro.albochallenge.transactions.data.network.manager.TransactionNetwork

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
class BeerNetworkImpl: NetworkConnectionImpl() {
    suspend fun getBeers(page: Int, items: Int): List<BeerResponse> {
        return retrofit.create(BeerNetwork::class.java).getBeers(page, items)
    }
}