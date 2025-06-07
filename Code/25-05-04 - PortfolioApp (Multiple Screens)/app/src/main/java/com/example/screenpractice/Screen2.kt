package com.example.screenpractice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // declarations for UI components
        val lblMessage1 = findViewById<TextView>(R.id.lblMessage1)
        val lblMessage2 = findViewById<TextView>(R.id.lblMessage2)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnClose = findViewById<Button>(R.id.btnClose)
        // this gets anything that we add to the intent as "extras" in the other screen
        val bundle : Bundle? = intent.extras

        // message1 is a GLOBAL variable, so we can call it without having to do anything special
        lblMessage1.text = strMessage1
        // message2 was passed in the INTENT as an EXTRA, so we need to get it from the BUNDLE
        lblMessage2.text = bundle?.getString("strMessage2")

        btnBack.setOnClickListener {
            // FINISH will exit the CURRENT screen
            finish()
        }

       btnClose.setOnClickListener {
           // FINISHAFFINITY will exit ALL screens
           finishAffinity()
           //System.exit(0)
       }

    }
}