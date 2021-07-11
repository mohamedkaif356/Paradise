package com.example.paradise.ui.allmemories

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.paradise.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoriesViewModel(application: Application) : AndroidViewModel(application) {

    val allMemories : LiveData<List<MemoriesTable>>
    val allFavourite : LiveData<List<FavouriteTable>>
    private val repository : MemoriesRepository

    init {
        val dao = MemoriesDatabase.getDatabase(application).getMemoriesDao()
        val dao2 = FavouriteDatabase.getDatabase(application).getFavouriteDao()
        repository = MemoriesRepository(dao, dao2)
        allMemories = repository.allMemories
        allFavourite = repository.allFavourite
    }

    fun insertMemories(memory: MemoriesTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(memory)
    }

    fun deleteMemories(memory: MemoriesTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(memory)
    }

    fun insertFavourite(favourite: FavouriteTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.favInsert(favourite)
    }

}