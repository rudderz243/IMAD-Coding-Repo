package com.example.pricechecker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        // first, we declare variables for our UI components
        val txtSearch = findViewById<EditText>(R.id.txtSearch)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        // next, we declare arrays for the product names and prices
        val nameArray = arrayOf("Pizza", "Drugs", "Shoes", "Durags", "Weapons", "Motorbikes")
        val priceArray = arrayOf(63000.00, 10.00, 700.00, 30.00, 5000.00, 150000.00)

        // we then create the OnClick method for our search button
        btnSearch.setOnClickListener {
            // get the input for the search
            var searchTerm = txtSearch.text.toString().lowercase()
            var counter = 0

            while (counter < nameArray.size) {
                // check if the current position in the array is equal to what we are looking for
                if (nameArray[counter].lowercase() == searchTerm) {
                    lblOutput.text = "The price of ${nameArray[counter]} is ${priceArray[counter]}"
                    // exit the loop, as we've found what we are looking for
                    break
                } else { // if the search does NOT match the current position in the array
                    lblOutput.text = "The product is not sold at our store."
                }
                // go to the next thing in the array so we can check it
                counter++
            }
        }

        // code to clear the input and output
        btnReset.setOnClickListener {
            txtSearch.text.clear()
            lblOutput.text = ""
        }

    }
}