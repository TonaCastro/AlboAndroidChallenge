package com.tonatiuhcastro.albochallenge.punkapi.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tonatiuhcastro.albochallenge.common.constants.NetworkConstants
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.common.domain.ResultException
import com.tonatiuhcastro.albochallenge.common.domain.ValidationError
import com.tonatiuhcastro.albochallenge.punkapi.data.dao.BeerDao
import com.tonatiuhcastro.albochallenge.punkapi.data.entity.toBeerModel
import com.tonatiuhcastro.albochallenge.punkapi.data.network.manager.BeerNetworkImpl
import com.tonatiuhcastro.albochallenge.punkapi.data.network.response.toBeerModel
import com.tonatiuhcastro.albochallenge.punkapi.domain.model.BeerModel
import com.tonatiuhcastro.albochallenge.punkapi.domain.repository.BeerRepository
import com.tonatiuhcastro.albochallenge.transactions.data.network.manager.TransactionNetworkImpl
import com.tonatiuhcastro.albochallenge.transactions.data.network.response.toTransactionModel
import com.tonatiuhcastro.albochallenge.transactions.domain.model.TransactionModel
import java.lang.Exception

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
class BeerRepositoryImpl(private val beerDao: BeerDao): BeerRepository {
    override suspend fun getNetworkBeers(page: Int, items: Int): LiveData<Result<List<BeerModel>>> {
        val data = MutableLiveData<Result<List<BeerModel>>>()
        try {
            val serviceNetwork = BeerNetworkImpl()
            serviceNetwork.onCreateConnection(NetworkConstants.HOST_PUNKAPI)
            val serviceResponse = serviceNetwork.getBeers(page, items)
            val listTransactions: List<BeerModel> = serviceResponse.map {
                it.toBeerModel()
            }
            data.value = Result.success(listTransactions)
        } catch (exception: Exception){
            data.value = Result.exception(ResultException(ValidationError.EXCEPTION,"", exception))
        }
        return data
    }

    override suspend fun getLocalBeers(): LiveData<Result<List<BeerModel>>> {
        val data = MutableLiveData<Result<List<BeerModel>>>()
        try {
            val beersLocal = beerDao.get()
            val listBeers: List<BeerModel> = beersLocal.map {
                it.toBeerModel()
            }
            data.value = Result.success(listBeers)
        } catch (exception: Exception){
            data.value = Result.exception(ResultException(ValidationError.EXCEPTION,"", exception))
        }
        return data
    }
}