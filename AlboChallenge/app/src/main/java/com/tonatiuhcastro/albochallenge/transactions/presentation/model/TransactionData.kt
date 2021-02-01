package com.tonatiuhcastro.albochallenge.transactions.presentation.model

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
data class TransactionData(var month: String,
                           var totalRejected : Int,
                           var totalPending: Int,
                           var totalIncomes: Double,
                           var totalExpenses: Double,
                           var spends: List<TransactionSpendData>?)

data class TransactionSpendData(var kind: String, var amount: Double)