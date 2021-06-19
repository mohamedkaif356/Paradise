package com.example.paradise

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoriesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertmemory(memory : MemoriesTable)

    @Delete
    suspend fun deletmemory(memory : MemoriesTable)

    @Query("Select * from memories_table order by id ASC")
    fun showallmemories() : LiveData<List<MemoriesTable>>
}