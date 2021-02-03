package com.tonatiuhcastro.albochallenge.transactions.presentation.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tonatiuhcastro.albochallenge.R
import com.tonatiuhcastro.albochallenge.databinding.TransactionFragmentBinding
import com.tonatiuhcastro.albochallenge.transactions.presentation.adapter.TransactionsAdapter
import com.tonatiuhcastro.albochallenge.transactions.presentation.factory.TransactionViewModelFactory
import com.tonatiuhcastro.albochallenge.transactions.presentation.viewmodel.TransactionViewModel

class TransactionFragment : Fragment() {

    companion object {
        fun newInstance() = TransactionFragment()
    }

    private lateinit var viewModel: TransactionViewModel
    private lateinit var binding: TransactionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = DataBindingUtil.inflate(inflater,
                R.layout.transaction_fragment, container, false)
            binding.lifecycleOwner = this
            return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            val factory = TransactionViewModelFactory()
            viewModel = ViewModelProvider(this, factory).get(TransactionViewModel::class.java)
            binding.viewmodel = viewModel
            manageObservers()
        }
    }

    private fun manageObservers() {
        goToScreens()
        getTransactions()
    }

    private fun getTransactions() {
        viewModel.getTransactionsLiveData().observe(viewLifecycleOwner, { list ->
            list?.let { listData ->
                val adapter = context?.let { it -> TransactionsAdapter(listData, it) }
                binding.listMonthResumeRvcontainer.adapter = adapter
            }
        })
    }

    private fun goToScreens() {

    }
}