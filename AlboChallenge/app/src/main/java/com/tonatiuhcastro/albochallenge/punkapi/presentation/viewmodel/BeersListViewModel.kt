package com.tonatiuhcastro.albochallenge.punkapi.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.common.presentation.ViewState
import com.tonatiuhcastro.albochallenge.punkapi.domain.usecase.BeerUseCase
import com.tonatiuhcastro.albochallenge.punkapi.presentation.model.BeerData
import kotlinx.coroutines.launch

class BeersListViewModel(private val beerUseCase: BeerUseCase) : ViewModel() {

    var viewStateData: MutableLiveData<ViewState> = MutableLiveData()
    private var beersLiveData: MutableLiveData<List<BeerData>?> = MutableLiveData()

    init {
        getBeers(1,20)
    }

    fun getBeersLiveData(): LiveData<List<BeerData>?> {
        return beersLiveData
    }

    private fun getBeers(page: Int, items: Int) {
        viewStateData.value = ViewState.LOADING
        viewModelScope.launch {
            beerUseCase.getBeerNetwork(page, items)
            viewStateData.value = ViewState.COMPLETED
            /*
            if (transactions?.status == Result.Status.SUCCESS && transactions.data?.size != 0) {
                transactionsLiveData.value = transactions.data
            }
             */
        }
    }
}