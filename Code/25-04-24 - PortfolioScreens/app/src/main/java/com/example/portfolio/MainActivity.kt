package com.example.portfolio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // declare variables for our UI
        val btnAboutMe = findViewById<Button>(R.id.btnAboutMe)
        val btnMyProjects = findViewById<Button>(R.id.btnMyProjects)

        // set instructions for clicking the about me button
        btnAboutMe.setOnClickListener {
            // create a new variable to hold the screen we want to switch to
            val intent = Intent(this, AboutMe::class.java)
            // switch to that screen
            startActivity(intent)
        }
        btnMyProjects.setOnClickListener {
            val intent = Intent(this, MyProjects::class.java)
            startActivity(intent)
        }


    }
}