package com.example.paradise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class AddMemoryViewModel(private val repository: MemoriesRepository) : ViewModel() {

    fun insertMemories(memory: MemoriesTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(memory)
    }
}