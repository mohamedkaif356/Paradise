package com.example.paradise.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paradise.R
import com.example.paradise.data.MemoriesTable
import com.example.paradise.ui.allmemories.ViewMemoryActivity
import kotlinx.android.synthetic.main.rv_all_post.view.*

class AllPostAdapter(val context: Context) :
    RecyclerView.Adapter<AllPostAdapter.MemoriesViewHolder>() {

    private val allmemories = ArrayList<MemoriesTable>()

    inner class MemoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title = view.memories_title!!
        val desc = view.memories_desc!!
        val image = view.memories_image!!
        val openmemories = view.cv_open_memories!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoriesViewHolder {
        val view = MemoriesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_all_post, parent, false)
        )

        return view
    }

    override fun onBindViewHolder(holder: MemoriesViewHolder, position: Int) {
        val currentMemory = allmemories[position]
        holder.title.text = currentMemory.title
        holder.desc.text = currentMemory.description
        holder.image.clipToOutline = true
        Glide.with(context).load(currentMemory.img).centerCrop().into(holder.image)
        holder.openmemories.setOnClickListener {
            val intent = Intent(context, ViewMemoryActivity::class.java)
            intent.putExtra(CURRENT_MEMORY, currentMemory)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return allmemories.count()
    }

    fun updateMemories(newMemory: List<MemoriesTable>) {

        allmemories.clear()
        allmemories.addAll(newMemory)
        notifyDataSetChanged()

    }

    companion object{
        var CURRENT_MEMORY = "memory"
    }

}



