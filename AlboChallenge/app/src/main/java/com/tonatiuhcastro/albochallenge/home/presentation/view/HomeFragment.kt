package com.tonatiuhcastro.albochallenge.home.presentation.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.tonatiuhcastro.albochallenge.R
import com.tonatiuhcastro.albochallenge.common.presentation.Screens
import com.tonatiuhcastro.albochallenge.databinding.HomeFragmentBinding
import com.tonatiuhcastro.albochallenge.home.presentation.viewmodel.HomeViewModel
import com.tonatiuhcastro.albochallenge.transactions.presentation.factory.TransactionViewModelFactory
import com.tonatiuhcastro.albochallenge.transactions.presentation.viewmodel.TransactionViewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.home_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
            binding.viewmodel = viewModel
            manageObservers()
        }
        manageObservers()
    }

    private fun manageObservers() {
        goToScreens()
    }

    private fun goToScreens() {
        viewModel.navigation.observe(viewLifecycleOwner, {

            when(it) {
                Screens.TRANSACTIONS -> findNavController().navigate(R.id.nav_transactions)
                Screens.PUNKAPI_LIST -> findNavController().navigate(R.id.nav_beers)
            }

        })
    }
}