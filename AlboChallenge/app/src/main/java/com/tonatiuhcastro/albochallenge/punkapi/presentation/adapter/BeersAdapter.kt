package com.tonatiuhcastro.albochallenge.punkapi.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tonatiuhcastro.albochallenge.R
import com.tonatiuhcastro.albochallenge.databinding.ItemBeerBinding
import com.tonatiuhcastro.albochallenge.databinding.ItemMonthResumeBinding
import com.tonatiuhcastro.albochallenge.punkapi.presentation.model.BeerData
import com.tonatiuhcastro.albochallenge.transactions.presentation.adapter.TransactionsAdapter
import kotlinx.android.synthetic.main.item_beer.view.*

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/2/21
 * @updated on
 * @modified by
 */

class BeersAdapter(private val beers: List<BeerData>, private val listener: (BeerData)->Unit):
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
        holder.bind(beer)
    }

    override fun getItemCount(): Int = beers.size

    inner class BeersViewHolder(view: ItemBeerBinding) : RecyclerView.ViewHolder(view.root) {
        var binding: ItemBeerBinding = view

        fun bind(beer: BeerData) {
            binding.itemBeerTvName.text =  beer.name
            binding.itemMonthTvtagline.text = beer.tagline

            Glide.with(binding.itemBeerImgbeer)
                .load(beer.imageUrl)
                .fitCenter()
                .into(binding.itemBeerImgbeer)

            binding.itemBeerContainer.setOnClickListener{
                listener.invoke(beer)
            }
        }
    }

}