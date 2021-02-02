package com.tonatiuhcastro.albochallenge.punkapi.domain.usecase

import com.tonatiuhcastro.albochallenge.punkapi.domain.repository.BeerRepository

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
class BeerUseCase(private val repository: BeerRepository ) {

    suspend fun getBeerNetwork(page: Int, items: Int) {
        repository.getNetworkBeers(page, items)
    }

    suspend fun getBeerLocal() {
        repository.getLocalBeers()
    }
}