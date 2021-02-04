package com.tonatiuhcastro.albochallenge.punkapi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tonatiuhcastro.albochallenge.punkapi.domain.model.BeerModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
@Entity(tableName = "beer")
data class BeerEntity(@PrimaryKey val id: Int,
                      val name: String,
                      val tagline: String,
                      val imageUrl: String,
                      val description : String,
                      val first_brewed: String,
                      val foodPairing: String)

fun BeerEntity.toBeerModel() =  BeerModel(id ,
    name,
    tagline,
    imageUrl,
    description,
    first_brewed,
    "")