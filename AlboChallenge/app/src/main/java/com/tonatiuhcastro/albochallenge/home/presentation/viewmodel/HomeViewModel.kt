package com.tonatiuhcastro.albochallenge.home.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tonatiuhcastro.albochallenge.common.presentation.Screens

class HomeViewModel : ViewModel() {

    var navigation: MutableLiveData<Screens> = MutableLiveData()

    fun onTransactionClicked() {
        navigation.value = Screens.TRANSACTIONS
    }

    fun onPunkAPIClicked() {
        navigation.value = Screens.PUNKAPI_LIST
    }
}