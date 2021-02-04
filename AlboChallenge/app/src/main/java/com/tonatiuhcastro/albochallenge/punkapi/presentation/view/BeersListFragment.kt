package com.tonatiuhcastro.albochallenge.punkapi.presentation.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tonatiuhcastro.albochallenge.R
import com.tonatiuhcastro.albochallenge.databinding.BeersListFragmentBinding
import com.tonatiuhcastro.albochallenge.punkapi.presentation.adapter.BeersAdapter
import com.tonatiuhcastro.albochallenge.punkapi.presentation.factory.BeerViewModelFactory
import com.tonatiuhcastro.albochallenge.punkapi.presentation.viewmodel.BeersListViewModel

class BeersListFragment : Fragment() {

    companion object {
        fun newInstance() = BeersListFragment()
    }

    private lateinit var viewModel: BeersListViewModel
    private lateinit var binding: BeersListFragmentBinding

    val onBeerClicked: (item: String) -> Unit = { beer ->
        goToDetail(beer)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.beers_list_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            val factory = BeerViewModelFactory(it)
            viewModel = ViewModelProvider(this, factory).get(BeersListViewModel::class.java)
            binding.viewmodel = viewModel
            manageObservers()
        }
    }

    private fun manageObservers() {
        getBeers()
    }

    private fun getBeers() {
        viewModel.getBeersLiveData().observe(viewLifecycleOwner, { list ->
            list?.let { listData ->
                val adapter = context?.let { it -> BeersAdapter(listData, onBeerClicked) }
                binding.listBeersRvcontainer.adapter = adapter
            }
        })
    }

    private fun goToDetail(beerSelected: String) {

        Toast.makeText(context, beerSelected, Toast.LENGTH_LONG).show()
    }

}