package com.example.paradise.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavouriteDao {   

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertmemory(memory : FavouriteTable)

    @Delete
    suspend fun deletmemory(memory : FavouriteTable)

    @Query("Select * from favourite_table order by id ASC")
    fun showallmemories() : LiveData<List<FavouriteTable>>
}