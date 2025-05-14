package com.example.timestable

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
        val txtInput = findViewById<EditText>(R.id.txtInput)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        btnCalculate.setOnClickListener {
            // get the number that the user entered
            val number = txtInput.text.toString().toInt()
            // declare a variable to hold our output
            var output = ""
            // declare a counter that starts at 0
            var counter = 0
            // loop until the counter is 10
            while (counter <= 10) {
                if (counter == 0) {
                    counter++
                    // lets us skip 1 run of the loop, and continues running it
                    continue
                }
                if (number > 20) {
                    output = "Please enter a number that is less than 20"
                    // exits out of the loop entirely, skipping it
                    break
                }
                // every time the loop runs, add the number multiplied by the current count to the output
                output += "${number} x ${counter} = ${number*counter}\n"
                // increase the counter by 1 every time the loop runs
                counter++
            }
            // output the final result
            lblOutput.text = output
        }

        btnReset.setOnClickListener {

        }
    }
}