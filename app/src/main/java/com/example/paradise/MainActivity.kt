package com.example.paradise


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.paradise.ui.addmemory.AddMemories
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragment)

        MainNavigationView.setupWithNavController(navController)

        btn_add_memories.setOnClickListener {
            startActivity(Intent(this, AddMemories::class.java))
        }

    }


}