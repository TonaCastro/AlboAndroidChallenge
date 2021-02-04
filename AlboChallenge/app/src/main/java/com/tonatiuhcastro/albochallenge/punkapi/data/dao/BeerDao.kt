package com.tonatiuhcastro.albochallenge.punkapi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tonatiuhcastro.albochallenge.punkapi.data.entity.BeerEntity

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
@Dao
interface BeerDao {
    @Query("select * from beer")
    suspend fun get(): List<BeerEntity>

    @Query("select * from beer where id = :identifier")
    suspend fun getUnique(identifier: Int): List<BeerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(user: BeerEntity)
}