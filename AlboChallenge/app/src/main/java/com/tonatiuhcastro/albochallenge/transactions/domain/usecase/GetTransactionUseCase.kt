package com.tonatiuhcastro.albochallenge.transactions.domain.usecase

import androidx.lifecycle.LiveData
import com.tonatiuhcastro.albochallenge.transactions.domain.repository.TransactionRepository

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
class GetTransactionUseCase(private val repository: TransactionRepository) {
    suspend fun execute() {
        repository.getListTransactions()
    }
}