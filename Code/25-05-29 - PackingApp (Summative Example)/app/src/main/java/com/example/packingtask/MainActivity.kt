package com.example.packingtask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// declaring GLOBAL parallel arrays
var itemNames = Array<String>(5) { "" }
var itemCategories = Array<String>(5) { "" }
var itemQuantities = Array<Int>(5) { 0 }
var itemComments = Array<String>(5) { "" }
var arrayPosition = 0

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
        // declare variables for the UI components
        val btnAddItem = findViewById<Button>(R.id.btnAddItem)
        val btnViewAll = findViewById<Button>(R.id.btnViewAll)
        val btnCloseApp = findViewById<Button>(R.id.btnCloseApp)
        val txtName = findViewById<EditText>(R.id.txtName)
        val txtCategory = findViewById<EditText>(R.id.txtCategory)
        val txtQuantity = findViewById<EditText>(R.id.txtQuantity)
        val txtComments = findViewById<EditText>(R.id.txtComments)
        val TAG = "PackingApp"

        // this method lets the user add a new item to the array, and checks the values to ensure that there are no errors
        btnAddItem.setOnClickListener {
            val itemName: String = txtName.text.toString()
            val itemCategory = txtCategory.text.toString()
            val itemQuantity = txtQuantity.text.toString()
            val itemComment = txtComments.text.toString()

            // checking if the name textbox is empty
            if (itemName.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Name cannot be blank, please enter a valid name and try again.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d(TAG, "The user did not enter an item name")
                // if the input is invalid, exit out of the onclick method
                return@setOnClickListener
            }
            if (itemCategory.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Category cannot be blank, please enter a valid category and try again.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d(TAG, "The user did not enter an item category")
                // if the input is invalid, exit out of the onclick method
                return@setOnClickListener
            }
            if (itemQuantity.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Quantity cannot be blank, please enter a valid number and try again.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d(TAG, "The user did not enter an item quantity")
                // if the input is invalid, exit out of the onclick method
                return@setOnClickListener
            }
            if (itemComment.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Comments cannot be blank, please enter a valid comment and try again.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d(TAG, "The user did not enter any item comments")
                // if the input is invalid, exit out of the onclick method
                return@setOnClickListener
            }
            // need to add to the array, but only if there is still space to add new items
            if (arrayPosition < 5) {
                itemNames[arrayPosition] = itemName
                itemCategories[arrayPosition] = itemCategory
                itemQuantities[arrayPosition] = itemQuantity.toInt()
                itemComments[arrayPosition] = itemComment
                arrayPosition++
                Toast.makeText(this, "Item added!", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Item added to array")
            } else {
                // display an error if the array is already full
                Toast.makeText(
                    this,
                    "The array is full. No more items can be added.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d(TAG, "User tried to add item to full array :(")
            }
        }

        // this method lets the user go to the second screen so that they can view all the items they've added
        btnViewAll.setOnClickListener {
            val Intent = Intent(this, SecondScreen::class.java)
            startActivity(Intent)
        }

        // this method exits the app
        btnCloseApp.setOnClickListener {
            finishAffinity()
        }

    }
}