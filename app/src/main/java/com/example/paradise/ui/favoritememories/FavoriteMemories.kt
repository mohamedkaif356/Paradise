package com.example.paradise.ui.favoritememories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paradise.R
import com.example.paradise.adapter.FavouritePostAdapter
import com.example.paradise.ui.allmemories.MemoriesViewModel

class FavoriteMemories : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_favourite, container, false)

        val adapter = FavouritePostAdapter(requireContext())
        val favouritePost = root.findViewById<RecyclerView>(R.id.rv_favourite_post)
        favouritePost.adapter = adapter
        favouritePost.layoutManager = GridLayoutManager(context, 2)

        val viewModel = ViewModelProvider(requireActivity()).get(MemoriesViewModel::class.java)

        viewModel.allFavourite.observe({lifecycle}){
            adapter.updateMemories(it)
        }

        return root
    }


}