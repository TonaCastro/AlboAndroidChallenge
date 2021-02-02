package com.tonatiuhcastro.albochallenge.common.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tonatiuhcastro.albochallenge.punkapi.data.dao.BeerDao
import com.tonatiuhcastro.albochallenge.punkapi.data.entity.BeerEntity

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
@Database(entities = arrayOf(BeerEntity::class),
    version = 1, exportSchema = false)
abstract class AlboDatabase: RoomDatabase() {

    abstract val beerDao: BeerDao

    companion object {

        @Volatile
        private var INSTANCE: AlboDatabase? = null

        fun getDatabase(context: Context): AlboDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AlboDatabase::class.java,
                        "albo_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
