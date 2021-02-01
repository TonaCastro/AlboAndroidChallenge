package com.tonatiuhcastro.albochallenge.transactions.domain.usecase

import androidx.lifecycle.LiveData
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.common.presentation.StatusTransaction
import com.tonatiuhcastro.albochallenge.common.utils.UtilsDate
import com.tonatiuhcastro.albochallenge.transactions.domain.model.TransactionModel
import com.tonatiuhcastro.albochallenge.transactions.domain.repository.TransactionRepository
import com.tonatiuhcastro.albochallenge.transactions.presentation.model.TransactionData

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
        val result = repository.getListTransactions()
        if (result.value?.status == Result.Status.EXCEPTION ) {
            //TODO: error
        } else {
            val listData = ArrayList<TransactionData>()
            result.value?.data?.forEach() {
                processTransaction(listData, it)
            }
        }
    }

    private fun processTransaction(listData: ArrayList<TransactionData>, model: TransactionModel): TransactionData {

        var transactionData: TransactionData? =
            listData.find { it.month == UtilsDate().stringToFormatDateMonth(model.creationDate) }

        if (transactionData == null) {
            transactionData = TransactionData()

            listData.add(transactionData)
        }

        when(model.status) {
            StatusTransaction.done.name -> {
                when (model.operation) {
                    "in" -> {
                        calculateIncomes(transactionData, model)
                    }
                    "out" -> {
                        calculateExpenses(transactionData, model)
                    }
                }
            }
            StatusTransaction.rejected.name -> {
                transactionData.totalRejected +=1
            }
            StatusTransaction.pendind.name -> {
                transactionData.totalPending +=1
            }
        }

        return transactionData
    }

    private fun calculateIncomes(transactionData: TransactionData, model: TransactionModel) {
        transactionData.totalIncomes += model.amount
    }

    private fun calculateExpenses(transactionData: TransactionData, model: TransactionModel) {
        transactionData.totalExpenses += model.amount
    }
}