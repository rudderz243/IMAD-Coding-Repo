package com.example.mathtest

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
        // declaring variables for UI components
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnCorrect = findViewById<Button>(R.id.btnCorrect)
        val btnIncorrect = findViewById<Button>(R.id.btnIncorrect)
        val lblProblem = findViewById<TextView>(R.id.lblProblem)
        // setting the default value for our label when the app starts
        lblProblem.text = "Welcome to the math quiz."
        // setting variables for us to keep track of the score
        var questionCounter: Int = 0
        var correctAnswers: Int = 0
        // declaring arrays for questions and answers
        var mathQuestions = arrayOf("1+2=4", "3*3=9", "3 log 2 = 1", "4-2=2", "5-0=5")
        var mathAnswers = arrayOf(false, true, false, false, true)
        // disable the answer buttons until the quiz is started
        btnCorrect.isEnabled = false
        btnIncorrect.isEnabled = false

        btnStart.setOnClickListener {
            // when the start button is pressed, reset both counters to 0 for the new attempt,
            // and re-enable the buttons so that the user can answer the questions
            questionCounter = 0
            correctAnswers = 0
            btnCorrect.isEnabled = true
            btnIncorrect.isEnabled = true
            lblProblem.text = mathQuestions[questionCounter]
        }

        btnCorrect.setOnClickListener {
            // if the math sum shown is correct (no problems),
            if (mathAnswers[questionCounter] == true) {
                // then we make the number of correct answers go up by 1
                correctAnswers++
            }
            // we then move our counter to deal with the next question
            questionCounter++
            // if that was the last question, then
            if (questionCounter == mathQuestions.count()) {
                // disable the controls for the quiz
                btnCorrect.isEnabled = false
                btnIncorrect.isEnabled = false
                // print out the score
                Toast.makeText(this, "You got ${correctAnswers} correct!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // otherwise, show the next math question
                lblProblem.text = mathQuestions[questionCounter]
            }
        }
        btnIncorrect.setOnClickListener {
            // if the math sum shown is incorrect (no problems),
            if (mathAnswers[questionCounter] == false) {
                // then we make the number of correct answers go up by 1
                correctAnswers++
            }
            // we then move our counter to deal with the next question
            questionCounter++
            // if that was the last question, then
            if (questionCounter == mathQuestions.count()) {
                // disable the controls for the quiz
                btnCorrect.isEnabled = false
                btnIncorrect.isEnabled = false
                // print out the score
                Toast.makeText(this, "You got ${correctAnswers} correct!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // otherwise, show the next math question
                lblProblem.text = mathQuestions[questionCounter]
            }
        }
    }
}