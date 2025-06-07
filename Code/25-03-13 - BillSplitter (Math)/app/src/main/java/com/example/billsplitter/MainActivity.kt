package com.example.billsplitter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // AUTO GENERATED CODE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // END, START WORKING HERE!
        val txtBillAmount = findViewById<EditText>(R.id.txtBillAmount)
        val txtNumberOfPeople = findViewById<EditText>(R.id.txtNumberOfPeople)
        val btnSplit = findViewById<Button>(R.id.btnSplitBill)
        val swIncludeTip = findViewById<Switch>(R.id.swIncludeTip)
        val lblSplitOutput = findViewById<TextView>(R.id.lblSplitOutput)
        val lblTipOutput = findViewById<TextView>(R.id.lblTipOutput)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            // reset button code
            txtBillAmount.text.clear()
            txtNumberOfPeople.text.clear()
            lblSplitOutput.text = ""
            lblTipOutput.text = ""
        }

        btnSplit.setOnClickListener {
            // get the values from the textbox
            val totalBillAmount : Double = txtBillAmount.text.toString().toDouble()
            val numberOfPeople : Int = txtNumberOfPeople.text.toString().toInt()

            // calculate the amount each person must pay
            val splitBillAmount : Double = totalBillAmount / numberOfPeople
            lblSplitOutput.text = "Each person must pay R" + splitBillAmount

            // if the tip is selected, calculate the tip amount from each person, otherwise display no tip
            if (swIncludeTip.isChecked) {
                val splitTipAmount = splitBillAmount * 0.1
                lblTipOutput.text = "Each person must contribute R" + splitTipAmount + " for tip."
            } else {
                lblTipOutput.text = "No tip included."
            }
        }
    }
}