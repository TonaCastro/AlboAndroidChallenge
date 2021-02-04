package com.tonatiuhcastro.albochallenge.punkapi.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.common.presentation.ViewState
import com.tonatiuhcastro.albochallenge.punkapi.domain.usecase.BeerDetailUseCase
import com.tonatiuhcastro.albochallenge.punkapi.presentation.model.BeerDetailData
import kotlinx.coroutines.launch

class BeerDetailViewModel(private val beerUseCase: BeerDetailUseCase, private  val identifier: Int?) : ViewModel() {

    var viewStateData: MutableLiveData<ViewState> = MutableLiveData()
    var beersLiveData: MutableLiveData<BeerDetailData> = MutableLiveData()
    var ImageBeerData: MutableLiveData<String> = MutableLiveData()

    init {
        getBeer()
    }

    private fun getBeer() {
        viewStateData.value = ViewState.LOADING
        viewModelScope.launch {
            val beer = beerUseCase.getBeerLocal(identifier ?: 0).value
            viewStateData.value = ViewState.COMPLETED
            if (beer?.status == Result.Status.SUCCESS && beer.data != null) {
                beersLiveData.value = beer.data
                ImageBeerData.value = beer.data?.imageUrl
            }
        }
    }
}