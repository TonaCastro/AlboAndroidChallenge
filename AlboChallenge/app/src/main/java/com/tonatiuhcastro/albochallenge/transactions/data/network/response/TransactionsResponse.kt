package com.tonatiuhcastro.albochallenge.transactions.data.network.response

import com.google.gson.annotations.SerializedName
import com.tonatiuhcastro.albochallenge.extensions.value
import com.tonatiuhcastro.albochallenge.transactions.domain.model.TransactionModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */

data class TransactionResponse (
    @SerializedName("uuid") val uuid: Long?,
    @SerializedName("description") val description: String?,
    @SerializedName("category") val category: String? = "",
    @SerializedName("operation") val operation: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("creation_date") val creationDate: String?,
    @SerializedName("amount") val amount: Double?
    )

fun TransactionResponse.toTransactionModel() = TransactionModel(category ?: "",
    operation ?: "",
    status ?: "",
    status ?: "",
    amount ?: 0.00)