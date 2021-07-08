package com.example.paradise.ui.allmemories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.paradise.R
import com.example.paradise.adapter.AllPostAdapter
import com.example.paradise.data.MemoriesTable
import kotlinx.android.synthetic.main.activity_view_memory.*

class ViewMemoryActivity : AppCompatActivity() {

    private lateinit var viewModel : MemoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_memory)

        var currentMemory : MemoriesTable? = null

        if (intent.hasExtra(AllPostAdapter.CURRENT_MEMORY)){
            currentMemory = intent.getSerializableExtra(AllPostAdapter.CURRENT_MEMORY) as MemoriesTable
        }

        viewModel = ViewModelProvider(this).get(MemoriesViewModel::class.java)

        if(currentMemory != null){
            tv_details_title.text = currentMemory.title
            tv_details_date.text = currentMemory.date
            tv_details_description.text = currentMemory.description
            Glide.with(this).load(currentMemory.img).into(iv_detail_image)
            tv_details_location.text = currentMemory.location
        }

        btn_delete_memory.setOnClickListener {
            viewModel.deleteMemories(currentMemory!!)
            Toast.makeText(this, "Memory Deleted successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}