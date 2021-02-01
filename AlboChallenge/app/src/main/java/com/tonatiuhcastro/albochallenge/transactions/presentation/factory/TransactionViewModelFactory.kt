package com.tonatiuhcastro.albochallenge.transactions.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tonatiuhcastro.albochallenge.transactions.data.repositoty.TransactionRepositoryImpl
import com.tonatiuhcastro.albochallenge.transactions.domain.repository.TransactionRepository
import com.tonatiuhcastro.albochallenge.transactions.domain.usecase.GetTransactionUseCase
import com.tonatiuhcastro.albochallenge.transactions.presentation.viewmodel.TransactionViewModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
@Suppress("UNCHECKED_CAST")
class TransactionViewModelFactory: ViewModelProvider.Factory {

    private val transactionRepository: TransactionRepository by lazy {
        TransactionRepositoryImpl()
    }

    private val getTransactionsUseCase: GetTransactionUseCase by lazy {
        GetTransactionUseCase(transactionRepository)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        when (modelClass){
            TransactionViewModel::class.java -> return TransactionViewModel(getTransactionsUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
