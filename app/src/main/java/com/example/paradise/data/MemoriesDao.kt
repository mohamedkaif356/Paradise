package com.example.paradise.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoriesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertmemory(memory : MemoriesTable)

    @Delete
    suspend fun deletmemory(memory : MemoriesTable)

    @Query("Select * from memories_table order by id ASC")
    fun showallmemories() : LiveData<List<MemoriesTable>>
}