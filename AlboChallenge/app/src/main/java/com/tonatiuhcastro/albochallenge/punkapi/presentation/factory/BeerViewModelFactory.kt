package com.tonatiuhcastro.albochallenge.punkapi.presentation.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tonatiuhcastro.albochallenge.common.database.AlboDatabase
import com.tonatiuhcastro.albochallenge.punkapi.data.repository.BeerDetailRepositoryImpl
import com.tonatiuhcastro.albochallenge.punkapi.data.repository.BeerRepositoryImpl
import com.tonatiuhcastro.albochallenge.punkapi.domain.repository.BeerDetailRepository
import com.tonatiuhcastro.albochallenge.punkapi.domain.repository.BeerRepository
import com.tonatiuhcastro.albochallenge.punkapi.domain.usecase.BeerDetailUseCase
import com.tonatiuhcastro.albochallenge.punkapi.domain.usecase.BeerUseCase
import com.tonatiuhcastro.albochallenge.punkapi.presentation.viewmodel.BeerDetailViewModel
import com.tonatiuhcastro.albochallenge.punkapi.presentation.viewmodel.BeersListViewModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/2/21
 * @updated on
 * @modified by
 */
@Suppress("UNCHECKED_CAST")
class BeerViewModelFactory(private val context: Context, private val identifier: Int? = 0): ViewModelProvider.Factory {

    private val datasource: AlboDatabase by lazy {
        AlboDatabase.getDatabase(context)
    }

    private val beerListRepository: BeerRepository by lazy {
        BeerRepositoryImpl(datasource.beerDao)
    }

    private val beerDetailRepository: BeerDetailRepository by lazy {
        BeerDetailRepositoryImpl(datasource.beerDao)
    }

    private val beerListUseCase: BeerUseCase by lazy {
        BeerUseCase(beerListRepository)
    }

    private val beerDetailUseCase: BeerDetailUseCase by lazy {
        BeerDetailUseCase(beerDetailRepository)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when (modelClass){
            BeersListViewModel::class.java -> return BeersListViewModel(beerListUseCase) as T
            BeerDetailViewModel::class.java -> return BeerDetailViewModel(beerDetailUseCase, identifier) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}