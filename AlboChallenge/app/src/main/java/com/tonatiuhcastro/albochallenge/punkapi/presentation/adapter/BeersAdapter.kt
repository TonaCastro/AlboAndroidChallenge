package com.tonatiuhcastro.albochallenge.punkapi.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tonatiuhcastro.albochallenge.R
import com.tonatiuhcastro.albochallenge.databinding.ItemBeerBinding
import com.tonatiuhcastro.albochallenge.databinding.ItemMonthResumeBinding
import com.tonatiuhcastro.albochallenge.punkapi.presentation.model.BeerData
import com.tonatiuhcastro.albochallenge.transactions.presentation.adapter.TransactionsAdapter

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/2/21
 * @updated on
 * @modified by
 */

class BeersAdapter(private val beers: List<BeerData>, private val context: Context):
    RecyclerView.Adapter<BeersAdapter.BeersViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BeersAdapter.BeersViewHolder {
        val binding: ItemBeerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_beer, parent, false)
        return BeersViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BeersAdapter.BeersViewHolder,
        position: Int
    ) {
        val beer = beers[position]
        holder.binding.itemBeerTvName.text =  beer.name
        holder.binding.itemMonthTvtagline.text = beer.tagline
    }

    override fun getItemCount(): Int = beers.size

    inner class BeersViewHolder(view: ItemBeerBinding) : RecyclerView.ViewHolder(view.root) {
        var binding: ItemBeerBinding = view
    }

}