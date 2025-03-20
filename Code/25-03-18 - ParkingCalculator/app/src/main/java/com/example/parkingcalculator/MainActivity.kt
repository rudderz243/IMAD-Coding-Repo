package com.example.parkingcalculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // auto generated
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // do not touch
        val txtParkingHours = findViewById<EditText>(R.id.txtHoursParked)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val swFreeParking = findViewById<Switch>(R.id.swFreeParking)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)
        val TAG = "ParkingCalculator"

        btnCalculate.setOnClickListener {
            if (txtParkingHours.text.isDigitsOnly()) {
                // get the number of hours from the textbox
                val hoursParked : Int = txtParkingHours.text.toString().toInt()
                // get whether the free parking switch is turned on
                val isParkingFree : Boolean = swFreeParking.isChecked

                // check whether the parking is free OR whether the hours are less than/equal to 1
                if (isParkingFree || hoursParked <= 1) {
                    // tell the user the parking is free!
                    lblOutput.text = "Your parking is free!"
                    Log.d(TAG, "The user received free parking.")
                    // otherwise, if neither are true
                } else {
                    // calculate the fee by multiplying the hours by 10
                    val feeToPay = hoursParked * 10
                    // display to the user
                    lblOutput.text = "You need to pay R" + feeToPay + " for parking."
                    Log.d(TAG, "The user paid for parking.")
                }
            } else {
                lblOutput.text = "Please enter a valid number."
                Log.d(TAG, "The user did not provide valid input.")
            }

        }

        btnReset.setOnClickListener {
            // clear the inputs and outputs
            txtParkingHours.text.clear()
            lblOutput.text = ""
            Log.d(TAG, "The user has cleared the inputs and outputs.")
        }
    }
}