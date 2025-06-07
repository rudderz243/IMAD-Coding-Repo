package com.example.screenpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

var strMessage1 : String = ""

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
        // declare variables for our UI components
        val txtMessage1 = findViewById<EditText>(R.id.txtMessage1)
        val txtMessage2 = findViewById<EditText>(R.id.txtMessage2)
        val btnSend = findViewById<Button>(R.id.btnSend)
        var strMessage2 : String = ""

        btnSend.setOnClickListener {
            strMessage1 = txtMessage1.text.toString()
            strMessage2 = txtMessage2.text.toString()

            val intent = Intent(this, Screen2::class.java)
            intent.putExtra("strMessage2", strMessage2)
            startActivity(intent)
        }
    }
}