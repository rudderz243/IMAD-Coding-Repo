package com.example.demo

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // prepare all components to be shown in the layout
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // get the buttons ready to be tapped!
        val btnAmericano = findViewById<Button>(R.id.button)
        val btnEspresso = findViewById<Button>(R.id.button3)
        val btnCappuccino = findViewById<Button>(R.id.button4)
        val btnCheckout = findViewById<Button>(R.id.button5)

        btnAmericano.setOnClickListener {
            // display that things have been added to the cart
            Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show()
        }

        btnEspresso.setOnClickListener {
            // display that things have been added to the cart
            Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show()
        }

        btnCappuccino.setOnClickListener {
            // display that things have been added to the cart
            Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show()
        }

        btnAmericano.setOnClickListener {
            // display that the order has been processed
            Toast.makeText(this, "Order on its way!", Toast.LENGTH_SHORT).show()
        }
    }
}