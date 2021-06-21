package com.example.paradise.ui.addmemory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paradise.data.MemoriesRepository
import com.example.paradise.data.MemoriesTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class AddMemoryViewModel(private val repository: MemoriesRepository) : ViewModel() {

    fun insertMemories(memory: MemoriesTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(memory)
    }
}