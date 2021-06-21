package com.example.paradise.data

import androidx.lifecycle.LiveData

class MemoriesRepository(private val memoriesDao : MemoriesDao) {

    val allMemories : LiveData<List<MemoriesTable>> = memoriesDao.showallmemories()

    suspend fun insert(memory : MemoriesTable) {

        memoriesDao.insertmemory(memory)
    }

    suspend fun delete(memory : MemoriesTable){

        memoriesDao.deletmemory(memory)
    }

}