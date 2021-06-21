package com.example.paradise.ui.addmemory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paradise.data.MemoriesRepository
import com.example.paradise.data.MemoriesTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class deleteMemoryViewModel(private val repository: MemoriesRepository) : ViewModel() {

    fun deletememory(memory: MemoriesTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(memory)
    }
}