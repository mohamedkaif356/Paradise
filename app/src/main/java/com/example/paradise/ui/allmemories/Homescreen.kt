package com.example.paradise.ui.allmemories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paradise.adapter.AllPostAdapter
import com.example.paradise.R


class Homescreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_homescreen, container, false)

        val adapter = AllPostAdapter(requireContext())
        val allpostrv = view.findViewById<RecyclerView>(R.id.all_post_rv)
        allpostrv.adapter = adapter
        allpostrv.layoutManager = GridLayoutManager(context, 2)


        val viewModel = ViewModelProvider(requireActivity()).get(MemoriesViewModel::class.java)


        viewModel.allMemories.observe({lifecycle}){
            adapter.updateMemories(it)
        }

        return view
    }

}

