package com.tonatiuhcastro.albochallenge.punkapi.domain.repository

import androidx.lifecycle.LiveData
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.punkapi.domain.model.BeerModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
interface BeerRepository {
    suspend fun getNetworkBeers(page: Int, items: Int): LiveData<Result<List<BeerModel>>>

    suspend fun getLocalBeers(): LiveData<Result<List<BeerModel>>>
}