package com.example.paradise.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paradise.R
import com.example.paradise.data.MemoriesTable
import kotlinx.android.synthetic.main.rv_all_post.view.*

class AllPostAdapter() :
    RecyclerView.Adapter<AllPostAdapter.MemoriesViewHolder>() {

    private val allmemories = ArrayList<MemoriesTable>()

        inner class MemoriesViewHolder(view : View) : RecyclerView.ViewHolder(view){

            val title = view.memories_title!!
            val desc = view.memories_desc!!
            val image = view.memories_image!!
            val openmemories = view.cv_open_memories!!

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoriesViewHolder {
        return MemoriesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_all_post, parent, false))
    }

    override fun onBindViewHolder(holder: MemoriesViewHolder, position: Int) {
        val currentMemory = allmemories[position]
        holder.title.text = currentMemory.title
        holder.desc.text = currentMemory.description
        holder.image.clipToOutline = true
        holder.image.setImageURI(Uri.parse(currentMemory.img))
    }

    override fun getItemCount(): Int {
        return allmemories.count()
    }

    public fun updateMemories(newMemory: List<MemoriesTable>){

        allmemories.clear()
        allmemories.addAll(newMemory)
        notifyDataSetChanged()

    }

    }



