package vcmsa.ci.numberguessor

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

        // start coding!
        val btn_guess = findViewById<Button>(R.id.btn_guess)
        val txt_input = findViewById<EditText>(R.id.txt_input)
        val lbl_output = findViewById<TextView>(R.id.lbl_output)

        btn_guess.setOnClickListener {
            // what happens when the button is clicked?
            val correct_number: Int = 42
            val guess = txt_input.text.toString().toInt()

            // if - else
            if (guess == correct_number) {
                lbl_output.text = "Congratulations! You guessed correctly."
            } else {
                lbl_output.text = "Please try again..."
            }

            // when
            when {
                guess == correct_number -> lbl_output.text = "Congratulations! You guessed correctly."
                else -> lbl_output.text = "Please try again..."
            }
        }
    }
}