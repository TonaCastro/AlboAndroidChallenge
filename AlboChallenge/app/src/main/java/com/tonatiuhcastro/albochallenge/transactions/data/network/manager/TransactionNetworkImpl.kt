package com.tonatiuhcastro.albochallenge.transactions.data.network.manager

import com.tonatiuhcastro.albochallenge.common.network.NetworkConnectionImpl
import com.tonatiuhcastro.albochallenge.transactions.data.network.response.TransactionResponse

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
class TransactionNetworkImpl: NetworkConnectionImpl() {

    suspend fun getTransactions(): List<TransactionResponse> {
        return retrofit.create(TransactionNetwork::class.java).getTransactions()
    }

}