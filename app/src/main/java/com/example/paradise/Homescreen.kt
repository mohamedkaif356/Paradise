package com.example.paradise

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Homescreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("Mohamed", "Hello")

        val view =  inflater.inflate(R.layout.fragment_homescreen, container, false)

        val adapter = AllPostAdapter()
        val allpostrv = view.findViewById<RecyclerView>(R.id.all_post_rv)
        allpostrv.adapter = adapter
        allpostrv.layoutManager = LinearLayoutManager(context)


        val viewModel = ViewModelProvider(requireActivity()).get(MemoriesViewModel::class.java)


        viewModel.allMemories.observe(viewLifecycleOwner, Observer {
            adapter.updateMemories(it)
        })

        return view
    }

}

