package com.tonatiuhcastro.albochallenge.transactions.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonatiuhcastro.albochallenge.common.domain.Result
import com.tonatiuhcastro.albochallenge.common.presentation.ViewState
import com.tonatiuhcastro.albochallenge.transactions.domain.usecase.GetTransactionUseCase
import com.tonatiuhcastro.albochallenge.transactions.presentation.model.TransactionData
import kotlinx.coroutines.launch

class TransactionViewModel(val transactionUseCase: GetTransactionUseCase) : ViewModel() {

    var viewStateData: MutableLiveData<ViewState> = MutableLiveData()
    private var transactionsLiveData: MutableLiveData<List<TransactionData>?> = MutableLiveData()

    init {
        getTransactions()
    }

    fun getTransactionsLiveData(): LiveData<List<TransactionData>?> {
        return transactionsLiveData
    }

    private fun getTransactions() {
        viewStateData.value = ViewState.LOADING
        viewModelScope.launch {
           val transactions = transactionUseCase.execute().value
            viewStateData.value = ViewState.COMPLETED
            if (transactions?.status == Result.Status.SUCCESS && transactions.data?.size != 0) {
                transactionsLiveData.value = transactions.data
            }
        }
    }
}