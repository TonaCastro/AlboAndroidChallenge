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
    private var swipeRefreshLiveData: MutableLiveData<Boolean> = MutableLiveData()

    private var currentPage = 1
    private  var itemsPage = 10

    init {
        getBeers(currentPage,itemsPage)
    }

    fun getBeersLiveData(): LiveData<List<BeerData>?> {
        return beersLiveData
    }

    fun getSwipeRefreshLiveData(): LiveData<Boolean> {
        return swipeRefreshLiveData
    }

    fun onRefresh() {
        currentPage += 1
        getBeers(currentPage, itemsPage)
        swipeRefreshLiveData.value = false
    }

    private fun getBeers(page: Int, items: Int) {
        viewStateData.value = ViewState.LOADING
        viewModelScope.launch {
           val beers = beerUseCase.getBeerNetwork(page, items).value
            viewStateData.value = ViewState.COMPLETED
            if (beers?.status == Result.Status.SUCCESS && beers.data?.size != 0) {
                beersLiveData.value = beers.data
            } else {
                currentPage -= 1
            }
        }
    }
}