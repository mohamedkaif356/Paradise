package com.example.paradise.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paradise.R
import com.example.paradise.data.FavouriteTable
import kotlinx.android.synthetic.main.rv_all_post.view.*

class FavouritePostAdapter(val context: Context) :
    RecyclerView.Adapter<FavouritePostAdapter.MemoriesViewHolder>() {

    private val allmemories = ArrayList<FavouriteTable>()

    inner class MemoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title = view.memories_title!!
        val desc = view.memories_desc!!
        val image = view.memories_image!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoriesViewHolder {

        return MemoriesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_all_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MemoriesViewHolder, position: Int) {
        val currentMemory = allmemories[position]
        holder.title.text = currentMemory.title
        holder.desc.text = currentMemory.description
        holder.image.clipToOutline = true
        Glide.with(context).load(currentMemory.img).centerCrop().into(holder.image)

    }

    override fun getItemCount(): Int {
        return allmemories.count()
    }

    fun updateMemories(newMemory: List<FavouriteTable>) {

        allmemories.clear()
        allmemories.addAll(newMemory)
        notifyDataSetChanged()

    }
}