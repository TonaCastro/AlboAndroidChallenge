package com.tonatiuhcastro.albochallenge.transactions.data.repositoty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tonatiuhcastro.albochallenge.common.constants.NetworkConstants
import com.tonatiuhcastro.albochallenge.common.domain.Resource
import com.tonatiuhcastro.albochallenge.transactions.data.network.manager.TransactionNetworkImpl
import com.tonatiuhcastro.albochallenge.transactions.data.network.response.toTransactionModel
import com.tonatiuhcastro.albochallenge.transactions.domain.model.TransactionModel
import com.tonatiuhcastro.albochallenge.transactions.domain.repository.TransactionRepository
import retrofit2.HttpException
import java.lang.Exception

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 1/31/21
 * @updated on
 * @modified by
 */
class TransactionRepositoryImpl: TransactionRepository {
    override suspend fun getListTransactions(): LiveData<Resource<List<TransactionModel>>> {

        val data = MutableLiveData<Resource<List<TransactionModel>>>()
        try {
            val serviceNetwork = TransactionNetworkImpl()
            serviceNetwork.onCreateConnection(NetworkConstants.HOST_TRANSACTIONS)
            val serviceResponse = serviceNetwork.getTransactions()
            val listTransactions: List<TransactionModel>? = serviceResponse.listTransactions?.map {
                it.toTransactionModel()
            }
            data.value = Resource.success(listTransactions)
        } catch (exception: Exception){
            data.value = Resource.exception(exception)
        }
        return data
    }
}