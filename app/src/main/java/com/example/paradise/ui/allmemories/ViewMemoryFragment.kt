package com.example.paradise.ui.allmemories

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.paradise.R
import com.example.paradise.data.MemoriesTable
import kotlinx.android.synthetic.main.fragment_view_memory.*

class ViewMemoryFragment : Fragment() {

    private val args by navArgs<ViewMemoryFragmentArgs>()
    private lateinit var viewmdel : MemoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_view_memory, container, false)

        viewmdel = ViewModelProvider(requireActivity()).get(MemoriesViewModel::class.java)

        val Image = root.findViewById<ImageView>(R.id.iv_details_image)

        Image.setImageURI(Uri.parse(args.currentMemory.img))

        return root
    }
}