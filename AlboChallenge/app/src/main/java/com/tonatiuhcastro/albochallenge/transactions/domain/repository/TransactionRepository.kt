package com.tonatiuhcastro.albochallenge.transactions.domain.repository

import androidx.lifecycle.LiveData
import com.tonatiuhcastro.albochallenge.common.domain.Resource
import com.tonatiuhcastro.albochallenge.transactions.domain.model.TransactionModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
interface TransactionRepository {
    suspend fun getListTransactions(): LiveData<Resource<List<TransactionModel>>>
}