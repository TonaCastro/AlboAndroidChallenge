package com.tonatiuhcastro.albochallenge.transactions.presentation.model

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
data class TransactionData(var month: String = "",
                           var monthNumber: Int = 0,
                           var totalRejected : Int = 0,
                           var totalPending: Int = 0,
                           var totalIncomes: Double = 0.0,
                           var totalExpenses: Double = 0.0,
                           var spends: List<TransactionSpendData>? = null)

data class TransactionSpendData(var kind: String, var amount: Double)