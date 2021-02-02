package com.tonatiuhcastro.albochallenge.punkapi.domain.model

import com.google.gson.annotations.SerializedName

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
data class BeerModel (val id: Int,
                      val name: String,
                      val tagline: String,
                      val imageUrl: String,
                      val description : String,
                      val first_brewed: String,
                      val foodPairing: List<String>)