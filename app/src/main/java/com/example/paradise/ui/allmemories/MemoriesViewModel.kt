package com.example.paradise.ui.allmemories

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.paradise.data.MemoriesDatabase
import com.example.paradise.data.MemoriesRepository
import com.example.paradise.data.MemoriesTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoriesViewModel(application: Application) : AndroidViewModel(application) {

    val allMemories : LiveData<List<MemoriesTable>>
    private val repository : MemoriesRepository

    init {
        val dao = MemoriesDatabase.getDatabase(application).getMemoriesDao()
        repository = MemoriesRepository(dao)
        allMemories = repository.allMemories
    }

    fun insertMemories(memory: MemoriesTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(memory)
    }

}