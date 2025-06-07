package com.example.packingtask

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // declaring variables for UI components
        val btnViewItems = findViewById<Button>(R.id.btnViewItems)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        // going back to the main screen
        btnBack.setOnClickListener {
            finish()
        }

        // view all items that have a quantity of 2 or more
        btnViewItems.setOnClickListener {
            var outputString: String = ""
            // for loop that runs from 0 to the position
            for (i in 0..arrayPosition) {
                if (itemQuantities[i] >= 2) {
                    outputString += "Item Name: " + itemNames[i] + "\n"
                    outputString += "Item Category: " + itemCategories[i] + "\n"
                    // we use toString here because quantity is a number
                    outputString += "Item Quantity: " + itemQuantities[i].toString() + "\n"
                    // we use 2 \n here so that there is a space between each item
                    outputString += "Item Comments: " + itemComments[i] + "\n\n"
                }
            }
            // display all items in the output label
            lblOutput.text = outputString
        }
    }
}