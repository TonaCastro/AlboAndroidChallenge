package com.tonatiuhcastro.albochallenge.punkapi.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.common.domain.ResultException
import com.tonatiuhcastro.albochallenge.common.domain.ValidationError
import com.tonatiuhcastro.albochallenge.punkapi.data.dao.BeerDao
import com.tonatiuhcastro.albochallenge.punkapi.data.entity.toBeerModel
import com.tonatiuhcastro.albochallenge.punkapi.domain.model.BeerModel
import com.tonatiuhcastro.albochallenge.punkapi.domain.repository.BeerDetailRepository
import java.lang.Exception

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/3/21
 * @updated on
 * @modified by
 */
class BeerDetailRepositoryImpl(private val beerDao: BeerDao): BeerDetailRepository {
    override suspend fun getLocalBeer(): LiveData<Result<List<BeerModel>>> {

        val data = MutableLiveData<Result<List<BeerModel>>>()
        try {
            val lstBeers = beerDao.get()
            val beers = lstBeers.map {
                it.toBeerModel()
            }
            data.value = Result.success(beers)
        } catch (exception: Exception){
            data.value = Result.exception(ResultException(ValidationError.EXCEPTION,"", exception))
        }
        return data

    }

}