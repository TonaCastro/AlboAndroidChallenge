package com.tonatiuhcastro.albochallenge.punkapi.data.network.response

import com.google.gson.annotations.SerializedName
import com.tonatiuhcastro.albochallenge.punkapi.domain.model.BeerModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
data class BeerResponse(@SerializedName("name") val name: String?,
                        @SerializedName("id") val id: Int?,
                        @SerializedName("tagline") val tagline: String?,
                        @SerializedName("image_url") val imageUrl: String?,
                        @SerializedName("description") val description: String?,
                        @SerializedName("first_brewed") val first_brewed: String?,
                        @SerializedName("food_pairing") val foodPairing: List<String>?)

fun BeerResponse.toBeerModel() =  BeerModel(id ?: 0,
                                            name ?: "",
                                            tagline ?: "",
                                            imageUrl?: "",
                                            description ?:"",
                                            first_brewed?: "",
                                            foodPairing ?: ArrayList())