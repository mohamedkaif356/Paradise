package com.example.paradise.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(FavouriteTable::class), version = 1, exportSchema = false)
abstract class FavouriteDatabase : RoomDatabase() {

    abstract fun getFavouriteDao() : FavouriteDao

    companion object{

        private var INSTANCE : FavouriteDatabase? = null

        fun getDatabase(context: Context) : FavouriteDatabase{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouriteDatabase::class.java,
                    "favourite_database"
                ).build()
                INSTANCE = instance
                instance
            }

        }

    }

}