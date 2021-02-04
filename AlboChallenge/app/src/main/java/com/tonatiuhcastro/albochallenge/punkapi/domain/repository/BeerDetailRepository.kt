package com.tonatiuhcastro.albochallenge.punkapi.domain.repository

import androidx.lifecycle.LiveData
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.punkapi.domain.model.BeerModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/3/21
 * @updated on
 * @modified by
 */
interface BeerDetailRepository {
    suspend fun getLocalBeer(identifier: Int): LiveData<Result<BeerModel>>
}