package com.example.paradise.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.paradise.MainActivity
import com.example.paradise.R
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        lifecycleScope.launch {
            animation()
        }
    }

    private suspend fun animation(){
        iv_splash_screen_logo.animate().alpha(1f).duration = 500L
        delay(200)
        val text = findViewById<TextView>(R.id.tv_splash_screen)
        text.animate().alpha(1f).duration = 500L
        delay(1000)
        iv_splash_screen_logo.animate().alpha(0f).duration = 500L
        delay(200)
        tv_splash_screen.animate().alpha(0f).duration = 500L
        delay(500)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}