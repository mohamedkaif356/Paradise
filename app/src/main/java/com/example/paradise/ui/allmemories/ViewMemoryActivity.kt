package com.example.paradise.ui.allmemories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.paradise.R
import com.example.paradise.adapter.AllPostAdapter
import com.example.paradise.data.MemoriesTable

class ViewMemoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_memory)

        var currentMemory : MemoriesTable? = null

        if (intent.hasExtra(AllPostAdapter.CURRENT_MEMORY)){
            currentMemory = intent.getSerializableExtra(AllPostAdapter.CURRENT_MEMORY) as MemoriesTable
        }


    }
}