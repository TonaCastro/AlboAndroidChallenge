package com.tonatiuhcastro.albochallenge.punkapi.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.punkapi.domain.model.toBeerDetailData
import com.tonatiuhcastro.albochallenge.punkapi.domain.repository.BeerDetailRepository
import com.tonatiuhcastro.albochallenge.punkapi.presentation.model.BeerDetailData

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/3/21
 * @updated on
 * @modified by
 */
class BeerDetailUseCase(private val repository: BeerDetailRepository) {

    suspend fun getBeerLocal(id: Int): LiveData<Result<BeerDetailData>>{
        val result = repository.getLocalBeer(id)
        val data = MutableLiveData<Result<BeerDetailData>>()
        if (result.value?.status == Result.Status.EXCEPTION ) {
            data.value = Result.exception(result.value?.exception)
        } else {
            data.value = Result.success(result.value?.data?.toBeerDetailData())
        }
        return data
    }
}