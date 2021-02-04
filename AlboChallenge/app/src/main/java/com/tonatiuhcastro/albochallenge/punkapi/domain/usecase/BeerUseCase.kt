package com.tonatiuhcastro.albochallenge.punkapi.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.punkapi.domain.model.toBeerData
import com.tonatiuhcastro.albochallenge.punkapi.domain.repository.BeerRepository
import com.tonatiuhcastro.albochallenge.punkapi.presentation.model.BeerData

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
class BeerUseCase(private val repository: BeerRepository ) {

    suspend fun getBeerNetwork(page: Int, items: Int): LiveData<Result<List<BeerData>>> {
        val result = repository.getNetworkBeers(page, items)
        val data = MutableLiveData<Result<List<BeerData>>>()
        if (result.value?.status == Result.Status.EXCEPTION ) {
            data.value = Result.exception(result.value?.exception)
        } else {
            val listData: List<BeerData>? = result.value?.data?.map {
                it.toBeerData()
            }
            data.value = Result.success(listData?.sortedBy { it.id })
        }
        return data
    }
}