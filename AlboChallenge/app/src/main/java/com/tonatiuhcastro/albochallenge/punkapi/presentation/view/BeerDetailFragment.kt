package com.tonatiuhcastro.albochallenge.punkapi.presentation.view

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.tonatiuhcastro.albochallenge.R
import com.tonatiuhcastro.albochallenge.databinding.BeerDetailFragmentBinding
import com.tonatiuhcastro.albochallenge.punkapi.presentation.factory.BeerViewModelFactory
import com.tonatiuhcastro.albochallenge.punkapi.presentation.viewmodel.BeerDetailViewModel
import com.tonatiuhcastro.albochallenge.punkapi.presentation.viewmodel.BeersListViewModel
import kotlinx.android.synthetic.main.beer_detail_fragment.*

class BeerDetailFragment : Fragment() {

    companion object {
        fun newInstance() = BeerDetailFragment()
        val ID_BEER = "idBeer"
        val NAME_BEER = "nameBeer"
    }

    private lateinit var viewModel: BeerDetailViewModel
    private lateinit var binding: BeerDetailFragmentBinding

    private var titleBeer = ""
    private var idBeer = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = titleBeer
        binding = DataBindingUtil.inflate(inflater,
            R.layout.beer_detail_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt(ID_BEER)?.let {
            idBeer = it
        }
        arguments?.getString(NAME_BEER)?.let {
            titleBeer = it
        }

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            val factory = BeerViewModelFactory(it, idBeer)
            viewModel = ViewModelProvider(this, factory).get(BeerDetailViewModel::class.java)
            binding.viewmodel = viewModel
            manageObservers()
        }
    }

    private fun manageObservers() {
        loadImageBeer()
    }

    private fun loadImageBeer() {
        viewModel.ImageBeerData.observe(viewLifecycleOwner, {
            Glide.with(detail_beer_imgbeer)
                .load(it)
                .fitCenter()
                .into(detail_beer_imgbeer)
        })
    }
}