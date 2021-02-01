package com.tonatiuhcastro.albochallenge.transactions.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonatiuhcastro.albochallenge.common.presentation.ViewState
import com.tonatiuhcastro.albochallenge.transactions.domain.usecase.GetTransactionUseCase
import kotlinx.coroutines.launch

class TransactionViewModel(val transactionUseCase: GetTransactionUseCase) : ViewModel() {

    var viewStateData: MutableLiveData<ViewState> = MutableLiveData()

    init {
        getTransactions()
    }

    private fun getTransactions() {
        viewStateData.value = ViewState.LOADING
        viewModelScope.launch {
            transactionUseCase.execute()
            viewStateData.value = ViewState.COMPLETED
        }

    }
}