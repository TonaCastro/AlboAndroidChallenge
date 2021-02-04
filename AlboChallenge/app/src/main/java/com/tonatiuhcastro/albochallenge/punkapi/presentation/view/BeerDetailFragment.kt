package com.tonatiuhcastro.albochallenge.punkapi.presentation.view

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tonatiuhcastro.albochallenge.R
import com.tonatiuhcastro.albochallenge.punkapi.presentation.viewmodel.BeerDetailViewModel

class BeerDetailFragment : Fragment() {

    companion object {
        fun newInstance() = BeerDetailFragment()
        val ID_BEER = "idBeer"
        val NAME_BEER = "nameBeer"
    }

    private lateinit var viewModel: BeerDetailViewModel

    private var titleBeer = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = titleBeer

        return inflater.inflate(R.layout.beer_detail_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt(ID_BEER)?.let {
            Toast.makeText(context, it.toString() + "desde detail", Toast.LENGTH_LONG).show()
        }
        arguments?.getString(NAME_BEER)?.let {
            titleBeer = it
        }

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BeerDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}