package com.tonatiuhcastro.albochallenge.transactions.domain.model

import com.google.gson.annotations.SerializedName

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
data class TransactionModel (var category: String,
                             var operation: String,
                             var status: String,
                             var creationDate: String,
                             var amount: Double)
