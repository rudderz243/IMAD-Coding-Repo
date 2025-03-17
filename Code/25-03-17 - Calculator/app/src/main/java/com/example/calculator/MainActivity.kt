package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // AUTO GENERATED CODE, DO NOT TOUCH
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // END OF AUTO GENERATED CODE

        val txtFirstNumber = findViewById<EditText>(R.id.txtFirstNumber)
        val txtSecondNumber = findViewById<EditText>(R.id.txtSecondNumber)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        btnAdd.setOnClickListener {
            // checking whether the user entered only numbers
            if (txtFirstNumber.text.isDigitsOnly() && txtSecondNumber.text.isDigitsOnly()) {
                // get the values from the textboxes, and convert them to numbers
                val firstNumber = txtFirstNumber.text.toString().toInt()
                val secondNumber = txtSecondNumber.text.toString().toInt()

                // do the calculation
                val answer = firstNumber + secondNumber

                // print out the answer
                lblOutput.text = "Answer: " + answer
            } else {
                lblOutput.text = "Please enter numbers only! :)"
            }
        }

        btnSubtract.setOnClickListener {
            // get the values from the textboxes, and convert them to numbers
            val firstNumber = txtFirstNumber.text.toString().toInt()
            val secondNumber = txtSecondNumber.text.toString().toInt()

            // do the calculation
            val answer = firstNumber - secondNumber

            // print out the answer
            lblOutput.text = "Answer: " + answer
        }

        btnMultiply.setOnClickListener {
            // get the values from the textboxes, and convert them to numbers
            val firstNumber = txtFirstNumber.text.toString().toInt()
            val secondNumber = txtSecondNumber.text.toString().toInt()

            // do the calculation
            val answer = firstNumber * secondNumber

            // print out the answer
            lblOutput.text = "Answer: " + answer
        }

        btnDivide.setOnClickListener {
            // get the values from the textboxes, and convert them to numbers
            val firstNumber = txtFirstNumber.text.toString().toInt()
            val secondNumber = txtSecondNumber.text.toString().toInt()

            // do the calculation
            val answer = firstNumber / secondNumber

            // print out the answer
            lblOutput.text = "Answer: " + answer
        }

        btnReset.setOnClickListener {
            txtFirstNumber.text.clear()
            txtSecondNumber.text.clear()
            lblOutput.text = ""
        }
    }
}