package com.example.paradise.data

import androidx.lifecycle.LiveData

class MemoriesRepository(private val memoriesDao : MemoriesDao, private val favouriteDao: FavouriteDao) {

    val allMemories : LiveData<List<MemoriesTable>> = memoriesDao.showallmemories()

    val allFavourite : LiveData<List<FavouriteTable>> = favouriteDao.showallmemories()

    suspend fun insert(memory : MemoriesTable) {

        memoriesDao.insertmemory(memory)
    }

    suspend fun delete(memory : MemoriesTable){

        memoriesDao.deletmemory(memory)
    }

    suspend fun favInsert(favourite : FavouriteTable){

        favouriteDao.insertmemory(favourite)
    }

}